package com.deepcare.controller.consultationFlow;

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
import com.deepcare.service.consultationFlow.ConsultationFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConsultationFlowController {

    private final ConsultationFlowService consultationFlowService;

    // F-1: [위기개입] 위기 프로토콜 활성화
    @PostMapping("/sessions/{session_id}/crisis-protocol")
    public ResponseEntity<CrisisProtocolCreateResponse> activateCrisisProtocol(
            @PathVariable("session_id") String sessionId,
            @RequestBody CrisisProtocolCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                consultationFlowService.activateCrisisProtocol(sessionId, request)
        );
    }

    // F-2: [위기개입] 위기조치 체크리스트 조회
    @GetMapping("/sessions/{session_id}/crisis-checklist")
    public ResponseEntity<CrisisChecklistResponse> getCrisisChecklist(
            @PathVariable("session_id") String sessionId
    ) {
        return ResponseEntity.ok(
                consultationFlowService.getCrisisChecklist(sessionId)
        );
    }

    // F-3: [위기개입] 체크리스트 완료 처리
    @PatchMapping("/sessions/{session_id}/crisis-checklist")
    public ResponseEntity<CrisisChecklistResponse> completeCrisisChecklist(
            @PathVariable("session_id") String sessionId,
            @RequestBody CrisisChecklistUpdateRequest request
    ) {
        return ResponseEntity.ok(
                consultationFlowService.completeCrisisChecklist(sessionId, request)
        );
    }

    // F-4: [프로그램 신청] 신청 등록
    @PostMapping("/clients/{client_id}/programs")
    public ResponseEntity<ProgramApplicationCreateResponse> createProgramApplication(
            @PathVariable("client_id") String clientId,
            @RequestBody ProgramApplicationCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                consultationFlowService.createProgramApplication(clientId, request)
        );
    }

    // F-5: [프로그램 신청] 신청 현황 조회
    @GetMapping("/clients/{client_id}/programs")
    public ResponseEntity<ProgramApplicationListResponse> getProgramApplications(
            @PathVariable("client_id") String clientId
    ) {
        return ResponseEntity.ok(
                consultationFlowService.getProgramApplications(clientId)
        );
    }

    // F-6: [프로그램 신청] 신청 상태 변경
    @PatchMapping("/clients/{client_id}/programs/{prog_id}")
    public ResponseEntity<ProgramApplicationResponse> changeProgramStatus(
            @PathVariable("client_id") String clientId,
            @PathVariable("prog_id") String progId,
            @RequestBody ProgramStatusChangeRequest request
    ) {
        return ResponseEntity.ok(
                consultationFlowService.changeProgramStatus(clientId, progId, request)
        );
    }

    // F-7: [사례관리] 단계 등록
    @PostMapping("/clients/{client_id}/case-stages")
    public ResponseEntity<CaseStageCreateResponse> createCaseStage(
            @PathVariable("client_id") String clientId,
            @RequestBody CaseStageCreateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                consultationFlowService.createCaseStage(clientId, request)
        );
    }

    // F-8: [사례관리] 단계 목록 조회
    @GetMapping("/clients/{client_id}/case-stages")
    public ResponseEntity<CaseStageListResponse> getCaseStageList(
            @PathVariable("client_id") String clientId
    ) {
        return ResponseEntity.ok(
                consultationFlowService.getCaseStageList(clientId)
        );
    }

    // F-9: [사례관리] 목표 달성률 조회
    @GetMapping("/clients/{client_id}/case-stages/progress")
    public ResponseEntity<CaseStageProgressResponse> getCaseStageProgress(
            @PathVariable("client_id") String clientId
    ) {
        return ResponseEntity.ok(
                consultationFlowService.getCaseStageProgress(clientId)
        );
    }

    // F-10: [가족상담] 화자 분리 설정
    @PatchMapping("/sessions/{session_id}/speaker-config")
    public ResponseEntity<SpeakerConfigResponse> setSpeakerConfig(
            @PathVariable("session_id") String sessionId,
            @RequestBody SpeakerConfigRequest request
    ) {
        return ResponseEntity.ok(
                consultationFlowService.setSpeakerConfig(sessionId, request)
        );
    }
}
