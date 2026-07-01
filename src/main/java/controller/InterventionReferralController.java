package controller;

import org.springframework.web.bind.annotation.*;

// 개입 및 연계
@RestController
@RequestMapping
public class InterventionReferralController {

    // I-1: 개입 내용 조회
    @GetMapping(path = "/sessions/{sessionId}/intervention")
    public String getIntervention() {
        return "";
    }

    // I-2: 개입 내용 등록
    @PostMapping(path = "/sessions/{sessionId}/intervention")
    public String createIntervention() {
        // TODO: AI 자동 추출
        return "";
    }

    // I-3: 개입 내용 수정
    @PatchMapping(path = "/sessions/{sessionId}/intervention")
    public String updateIntervention() {
        return "";
    }

    // I-4: 연계 기관 마스터 조회
    @GetMapping(path = "/agencies")
    public String getReferralAgencyMaster() {
        // TODO: 기관명 서비스 검색
        return "";
    }

    // I-5: 연계 서비스 마스터 조회
    @GetMapping(path = "/services")
    public String getReferralServiceMaster() {
        return "";
    }

}
