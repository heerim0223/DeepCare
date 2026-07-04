package com.deepcare.service.consultationFlow;

import com.deepcare.domain.client.Client;
import com.deepcare.domain.consultationFlow.CaseGoal;
import com.deepcare.domain.consultationFlow.CaseStage;
import com.deepcare.domain.consultationFlow.CrisisProtocol;
import com.deepcare.domain.consultationFlow.ProgramApplication;
import com.deepcare.domain.notification.Notification;
import com.deepcare.domain.session.Session;
import com.deepcare.domain.session.SessionParticipant;
import com.deepcare.dto.consultationFlow.request.CaseStageCreateRequest;
import com.deepcare.dto.consultationFlow.request.CrisisChecklistUpdateRequest;
import com.deepcare.dto.consultationFlow.request.CrisisProtocolCreateRequest;
import com.deepcare.dto.consultationFlow.request.ProgramApplicationCreateRequest;
import com.deepcare.dto.consultationFlow.request.ProgramStatusChangeRequest;
import com.deepcare.dto.consultationFlow.request.SpeakerConfigRequest;
import com.deepcare.dto.consultationFlow.response.CaseStageCreateResponse;
import com.deepcare.dto.consultationFlow.response.CaseStageListResponse;
import com.deepcare.dto.consultationFlow.response.CaseStageProgressResponse;
import com.deepcare.dto.consultationFlow.response.CrisisChecklistResponse;
import com.deepcare.dto.consultationFlow.response.CrisisProtocolCreateResponse;
import com.deepcare.dto.consultationFlow.response.ProgramApplicationCreateResponse;
import com.deepcare.dto.consultationFlow.response.ProgramApplicationListResponse;
import com.deepcare.dto.consultationFlow.response.ProgramApplicationResponse;
import com.deepcare.dto.consultationFlow.response.SpeakerConfigResponse;
import com.deepcare.repository.client.ClientRepository;
import com.deepcare.repository.consultationFlow.CaseStageRepository;
import com.deepcare.repository.consultationFlow.CrisisProtocolRepository;
import com.deepcare.repository.consultationFlow.ProgramApplicationRepository;
import com.deepcare.repository.session.SessionParticipantRepository;
import com.deepcare.repository.session.SessionRepository;
import com.deepcare.service.notification.NotificationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ConsultationFlowService {

    private final CrisisProtocolRepository crisisProtocolRepository;
    private final ProgramApplicationRepository programApplicationRepository;
    private final CaseStageRepository caseStageRepository;
    private final SessionRepository sessionRepository;
    private final SessionParticipantRepository sessionParticipantRepository;
    private final ClientRepository clientRepository;
    private final NotificationService notificationService;

    // F-1: [위기개입] 위기 프로토콜 활성화
    public CrisisProtocolCreateResponse activateCrisisProtocol(String sessionId, CrisisProtocolCreateRequest request) {
        Session session = getSessionEntity(sessionId);

        CrisisProtocol crisisProtocol = CrisisProtocol.create(
                session,
                request.crisisType(),
                request.notifySupervisor()
        );
        crisisProtocolRepository.save(crisisProtocol);

        List<Notification> notifications = crisisProtocol.getNotifySupervisor()
                ? notificationService.sendCrisisProtocolAlert(session, crisisProtocol)
                : List.of();

        return CrisisProtocolCreateResponse.of(crisisProtocol, notifications);
    }

    // F-2: [위기개입] 위기조치 체크리스트 조회
    public CrisisChecklistResponse getCrisisChecklist(String sessionId) {
        CrisisProtocol crisisProtocol = getCrisisProtocolEntity(sessionId);

        return CrisisChecklistResponse.from(crisisProtocol.getChecklistItems());
    }

    // F-3: [위기개입] 체크리스트 완료 처리
    public CrisisChecklistResponse completeCrisisChecklist(String sessionId, CrisisChecklistUpdateRequest request) {
        CrisisProtocol crisisProtocol = getCrisisProtocolEntity(sessionId);

        List<CrisisChecklistUpdateRequest.Item> checklistItems = request.checklistItems() == null
                ? List.of()
                : request.checklistItems();
        Map<String, CrisisChecklistUpdateRequest.Item> requestItems = checklistItems.stream()
                .collect(Collectors.toMap(CrisisChecklistUpdateRequest.Item::id, Function.identity()));

        crisisProtocol.getChecklistItems().forEach(item -> {
            CrisisChecklistUpdateRequest.Item requestItem = requestItems.get(item.getId());
            if (requestItem != null) {
                item.changeDone(requestItem.done());
            }
        });

        return CrisisChecklistResponse.from(crisisProtocol.getChecklistItems());
    }

    // F-4: [프로그램 신청] 신청 등록
    public ProgramApplicationCreateResponse createProgramApplication(String clientId, ProgramApplicationCreateRequest request) {
        Client client = getClientEntity(clientId);

        ProgramApplication programApplication = ProgramApplication.create(
                client,
                request.programId(),
                request.docsRequired()
        );
        programApplicationRepository.save(programApplication);

        return ProgramApplicationCreateResponse.from(programApplication);
    }

    // F-5: [프로그램 신청] 신청 현황 조회
    public ProgramApplicationListResponse getProgramApplications(String clientId) {
        List<ProgramApplication> programApplications = programApplicationRepository.findByClient_Id(clientId);

        return ProgramApplicationListResponse.from(programApplications);
    }

    // F-6: [프로그램 신청] 신청 상태 변경
    public ProgramApplicationResponse changeProgramStatus(String clientId, String progId, ProgramStatusChangeRequest request) {
        ProgramApplication programApplication = programApplicationRepository.findByIdAndClient_Id(progId, clientId)
                .orElseThrow(() -> new IllegalArgumentException("프로그램 신청 정보를 찾을 수 없습니다."));

        programApplication.changeStatus(request.status());

        return ProgramApplicationResponse.from(programApplication);
    }

    // F-7: [사례관리] 단계 등록
    public CaseStageCreateResponse createCaseStage(String clientId, CaseStageCreateRequest request) {
        Client client = getClientEntity(clientId);

        CaseStage caseStage = CaseStage.create(client, request.stage(), request.goals());
        caseStageRepository.save(caseStage);

        return CaseStageCreateResponse.from(caseStage);
    }

    // F-8: [사례관리] 단계 목록 조회
    public CaseStageListResponse getCaseStageList(String clientId) {
        List<CaseStage> caseStages = caseStageRepository.findByClient_IdOrderByCreatedAtAsc(clientId);

        return CaseStageListResponse.from(caseStages);
    }

    // F-9: [사례관리] 목표 달성률 조회
    public CaseStageProgressResponse getCaseStageProgress(String clientId) {
        List<CaseGoal> goals = caseStageRepository.findByClient_IdOrderByCreatedAtAsc(clientId).stream()
                .flatMap(caseStage -> caseStage.getGoals().stream())
                .toList();

        int totalGoals = goals.size();
        int achieved = (int) goals.stream()
                .filter(goal -> Boolean.TRUE.equals(goal.getAchieved()))
                .count();

        return CaseStageProgressResponse.of(totalGoals, achieved);
    }

    // F-10: [가족상담] 화자 분리 설정
    public SpeakerConfigResponse setSpeakerConfig(String sessionId, SpeakerConfigRequest request) {
        getSessionEntity(sessionId);

        List<SessionParticipant> participants = sessionParticipantRepository.findBySession_Id(sessionId);
        List<String> speakers = request.speakers() == null ? List.of() : request.speakers();
        Map<String, Integer> speakerIndexByFamilyMemberId = new HashMap<>();
        for (int i = 0; i < speakers.size(); i++) {
            speakerIndexByFamilyMemberId.putIfAbsent(speakers.get(i), i);
        }

        participants.forEach(participant -> {
            if (participant.getClientFamilyMember() != null) {
                Integer speakerIndex = speakerIndexByFamilyMemberId.get(participant.getClientFamilyMember().getId());
                if (speakerIndex != null) {
                    participant.changeSpeakerIndex(speakerIndex);
                }
            }
        });

        return SpeakerConfigResponse.from(participants);
    }

    // ====

    private Session getSessionEntity(String sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("상담 회기를 찾을 수 없습니다."));
    }

    private Client getClientEntity(String clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("클라이언트를 찾을 수 없습니다."));
    }

    private CrisisProtocol getCrisisProtocolEntity(String sessionId) {
        return crisisProtocolRepository.findBySession_Id(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("위기 프로토콜을 찾을 수 없습니다."));
    }
}
