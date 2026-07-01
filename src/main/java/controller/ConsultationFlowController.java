package controller;

import org.springframework.web.bind.annotation.*;

// 상담 유형별 플로우
@RestController
public class ConsultationFlowController {

    // FL-1: [위기개입] 위기 프로토콜 활성화
    @PostMapping("/sessions/{session_id}/crisis-protocol")
    public String activateCrisisProtocol(@PathVariable("session_id") String sessionId) {
        // TODO: 슈퍼바이저·관리자 Push 즉시 발송
        return "";
    }

    // FL-2: [위기개입] 위기조치 체크리스트 조회
    @GetMapping("/sessions/{session_id}/crisis-checklist")
    public String getCrisisChecklist(@PathVariable("session_id") String sessionId) {
        // TODO: 필수 안전 확인 항목
        return "";
    }

    // FL-3: [위기개입] 체크리스트 완료 처리
    @PatchMapping("/sessions/{session_id}/crisis-checklist")
    public String completeCrisisChecklist(@PathVariable("session_id") String sessionId) {
        // TODO: 미완료 시 회기 저장 불가
        return "";
    }

    // FL-4: [프로그램 신청] 신청 등록
    @PostMapping("/clients/{client_id}/programs")
    public String createProgramStatus(@PathVariable("client_id") String clientId) {
        // TODO: 자격조건 자동 체크
        return "";
    }

    // FL-5: [프로그램 신청] 신청 현황 조회
    @GetMapping("/clients/{client_id}/programs")
    public String getProgramStatus(
            @PathVariable("client_id") String clientId
    ) {
        // TODO: 접수→심사→결정→통보 단계
        return "";
    }

    // FL-6: [프로그램 신청] 신청 상태 변경
    @PatchMapping("/clients/{client_id}/programs/{prog_id}")
    public String changeProgramStatus(
            @PathVariable("client_id") String clientId,
            @PathVariable("prog_id") String progId
    ) {
        // TODO: 필요 서류 제출 현황 연동
        return "";
    }

    // FL-7: [사례관리] 단계 등록
    @PostMapping("/clients/{client_id}/case-stages")
    public String createCaseStage(@PathVariable("client_id") String clientId) {
        // TODO: 초기사정→욕구사정→계획→개입→모니터링→종결
        return "";
    }

    // FL-8: [사례관리] 단계 목록 조회
    @GetMapping("/clients/{client_id}/case-stages")
    public String getCaseStageList(@PathVariable("client_id") String clientId) {
        return "";
    }

    // FL-9: [사례관리] 목표 달성률 조회
    @GetMapping("/clients/{client_id}/case-stages/progress")
    public String getCaseStageProgress(@PathVariable("client_id") String clientId) {
        // TODO: 설정 목표 대비 현황 자동 산출
        return "";
    }

    // FL-10: [가족상담] 화자 분리 설정
    @PatchMapping("/sessions/{session_id}/speaker-config")
    public String setSpeakerConfig(@PathVariable("session_id") String sessionId) {
        // TODO: 가족 구성원별 발언 분리 STT
        return "";
    }

}
