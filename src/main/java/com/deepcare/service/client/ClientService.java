package com.deepcare.service.client;

import com.deepcare.domain.accessLink.AccessLink;
import com.deepcare.domain.client.Client;
import com.deepcare.domain.riskAssessment.RiskAssessment;
import com.deepcare.domain.riskAssessment.RiskLevel;
import com.deepcare.domain.session.Session;
import com.deepcare.domain.user.User;
import com.deepcare.dto.client.request.ClientCreateRequest;
import com.deepcare.dto.client.request.ClientUpdateRequest;
import com.deepcare.dto.client.response.*;
import com.deepcare.repository.accessLink.AccessLinkRepository;
import com.deepcare.repository.client.ClientRepository;
import com.deepcare.repository.riskAssessment.RiskAssessmentRepository;
import com.deepcare.repository.session.SessionRepository;
import com.deepcare.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    /*
        TODO: 예외처리

        throw new IllegalArgumentException(...)을
        ClientNotFoundException 이나
        AccessLinkNotFoundException 과 같은
        커스텀 예외로 분류
    */

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final AccessLinkRepository accessLinkRepository;
    private final SessionRepository sessionRepository;
    private final RiskAssessmentRepository riskAssessmentRepository;

    // C-1: 클라이언트 목록 조회 ([R-4: 위험 클라이언트 목록] 포함)
    public ClientListGetResponse getClientList(String riskLevel) {
        List<Client> clients = clientRepository.findByDeletedFalse();

        List<ClientListItem> items = clients.stream()
                .map(client -> ClientListItem.of(client, findLatestRiskLevel(client.getId())))
                .filter(item -> matchesRiskLevel(item.riskLevel(), riskLevel))
                .toList();

        return ClientListGetResponse.of(items);
    }

    private boolean matchesRiskLevel(RiskLevel actual, String requested) {
        if (requested == null || requested.isBlank()) {
            return true;
        }
        return actual != null && actual.name().equalsIgnoreCase(requested);
    }

    // 클라이언트의 가장 최근 회기에 기록된 위험 수준 조회
    private RiskLevel findLatestRiskLevel(String clientId) {
        List<Session> sessions = sessionRepository.findByClient_IdOrderByDateDesc(clientId);

        return sessions.stream()
                .map(session -> riskAssessmentRepository.findBySession_Id(session.getId()).orElse(null))
                .filter(Objects::nonNull)
                .map(RiskAssessment::getRiskLevel)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    // C-2: 클라이언트 등록
    public ClientCreateResponse createClient(ClientCreateRequest request) {
        User primaryWorker = userRepository.findById(request.primaryWorkerUserId())
                .orElseThrow(() -> new IllegalArgumentException("담당자를 찾을 수 없습니다."));

        Client client = Client.builder()
                        .name(request.name())
                        .birthDate(request.birthDate())
                        .gender(request.gender())
                        .contactPhone(request.contactPhone())
                        .primaryWorker(primaryWorker)
                        .build();

        clientRepository.save(client);

        return new ClientCreateResponse(
                client.getId()
        );
    }

    // C-3: 클라이언트 상세 조회
    public ClientGetResponse getClient(String clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("클라이언트를 찾을 수 없습니다."));

        return ClientGetResponse.from(client);
    }

    // C-4: 클라이언트 정보 수정
    public ClientUpdateResponse updateClient(String clientId, ClientUpdateRequest request) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("클라이언트를 찾을 수 없습니다."));

        client.update(
                request.name(),
                request.birthDate(),
                request.gender(),
                request.contactPhone(),
                request.address(),
                request.nationality(),
                request.disabilityYn(),
                request.disabilityType()
        );

        return ClientUpdateResponse.from(client);
    }

    // C-5: 클라이언트 삭제(비활성화)
    public void deactivateClient(String clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("클라이언트를 찾을 수 없습니다."));

        client.deactivate();
    }

    // C-6: 클라이언트 검색
    public ClientSearchResponse searchClient(String q) {
        List<Client> clients = clientRepository.findByNameContainingOrContactPhoneContaining(q, q);

        return ClientSearchResponse.from(clients);
    }

    // C-7: 내담자 앱 접근 링크 발송
    public SendAccessLinkResponse sendAccessLink(String clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("클라이언트를 찾을 수 없습니다."));

        // TODO: 외부 서비스(SMS / Email 발송) 호출 로직 구현
        // smsService.send(client.getContactPhone(), accessLink);

        AccessLink existing = accessLinkRepository.findByClient_Id(clientId).orElse(null);
        boolean reusable = existing != null
                && existing.getStatus() == com.deepcare.domain.accessLink.Status.PENDING
                && !existing.isExpired();

        AccessLink accessLink;
        if (reusable) {
            // 기존 PENDING 링크가 있으면 재사용
            accessLink = existing;
        } else {
            if (existing != null && existing.getStatus() != com.deepcare.domain.accessLink.Status.JOINED) {
                existing.expire();
            }

            String token = UUID.randomUUID().toString();
            LocalDateTime expiresAt = LocalDateTime.now().plusDays(7);

            accessLink = AccessLink.create(client, token, expiresAt);
            accessLinkRepository.save(accessLink);
        }

        return SendAccessLinkResponse.from(client, accessLink);
    }

    // C-8: 내담자 앱 접근 링크 상태 조회
    public GetAccessLinkStatusResponse getAccessLinkStatus(String clientId) {
        AccessLink accessLink = accessLinkRepository.findByClient_Id(clientId)
                .orElseThrow(() -> new IllegalArgumentException("접근 링크를 찾을 수 없습니다."));

        if(accessLink.isExpired()) {
            accessLink.expire();
        }

        return GetAccessLinkStatusResponse.from(accessLink);
    }

}
