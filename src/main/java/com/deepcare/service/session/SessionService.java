package com.deepcare.service.session;

import com.deepcare.domain.client.Client;
import com.deepcare.domain.session.Session;
import com.deepcare.domain.session.Status;
import com.deepcare.domain.user.User;
import com.deepcare.dto.session.request.SessionCreateRequest;
import com.deepcare.dto.session.request.SessionUpdateRequest;
import com.deepcare.dto.session.response.*;
import com.deepcare.repository.client.ClientRepository;
import com.deepcare.repository.session.SessionRepository;
import com.deepcare.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    // S-1: 회기 목록 조회
    public SessionListGetResponse getSessionList(String clientId) {
        List<Session> sessions = sessionRepository.findByClient_IdOrderByDateDesc(clientId);

        List<SessionListItem> items = sessions.stream()
                .filter(session -> !session.getDeleted())
                .map(SessionListItem::from)
                .toList();

        return SessionListGetResponse.of(items);
    }

    // S-2: 회기 등록 (상담 시작)
    // TODO: 상담 유형 선택 → 플로우 자동 결정 (위기개입/프로그램신청/사례관리/가족상담 등 ConsultationFlow 연동)
    public SessionCreateResponse createSession(String clientId, SessionCreateRequest request) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("클라이언트를 찾을 수 없습니다."));

        User workerUser = userRepository.findById(request.workerUserId())
                .orElseThrow(() -> new IllegalArgumentException("담당자를 찾을 수 없습니다."));

        Integer number = request.number() != null
                ? request.number()
                : (int) sessionRepository.countByClient_Id(clientId) + 1;

        Session session = Session.builder()
                .client(client)
                .date(request.sessionDate())
                .timeStart(request.timeStart())
                .timeEnd(request.timeEnd())
                .durationMin(request.durationMin())
                .method(request.method())
                .location(request.location())
                .type(request.type())
                .number(number)
                .workerUser(workerUser)
                .status(request.status() != null ? request.status() : Status.DRAFT)
                .build();

        sessionRepository.save(session);

        return SessionCreateResponse.from(session);
    }

    // S-3: 회기 상세
    public GetSessionResponse getSession(String sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("회기를 찾을 수 없습니다."));

        return GetSessionResponse.from(session);
    }

    // S-4: 회기 수정
    public SessionUpdateResponse updateSession(String sessionId, SessionUpdateRequest request) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("회기를 찾을 수 없습니다."));

        session.update(
            request.number(),
            request.sessionDate(),
            request.timeStart(),
            request.timeEnd(),
            request.durationMin(),
            request.method(),
            request.type(),
            request.status()
        );

        return SessionUpdateResponse.from(session);
    }

    // S-5: 회기 삭제
    public void removeSession(String sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("회기를 찾을 수 없습니다."));

        session.remove();
    }

    // S-6: 예정 상담 일정 조회 (사회복지사 캘린더)
    public SessionUpcomingGetResponse getUpcomingSession(String workerId) {
        LocalDate today = LocalDate.now();

        List<SessionUpcomingItem> items = sessionRepository
                .findByWorkerUser_IdAndDeletedFalseOrderByDateAscTimeStartAsc(workerId)
                .stream()
                .filter(session -> !session.getDate().isBefore(today))
                .map(SessionUpcomingItem::from)
                .toList();

        return SessionUpcomingGetResponse.of(items);
    }
}
