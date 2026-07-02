package com.deepcare.controller.interventionReferral;

import org.springframework.web.bind.annotation.*;

// 개입 및 연계
@RestController
public class InterventionReferralController {

    // I-1: 개입 내용 조회
    @GetMapping("/sessions/{session_id}/intervention")
    public String getIntervention(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // I-2: 개입 내용 등록
    @PostMapping("/sessions/{session_id}/intervention")
    public String createIntervention(@PathVariable("session_id") String sessionId) {
        // TODO: AI 자동 추출
        return "";
    }

    // I-3: 개입 내용 수정
    @PatchMapping("/sessions/{session_id}/intervention")
    public String updateIntervention(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // I-4: 연계 기관 마스터 조회
    @GetMapping("/agencies")
    public String getReferralAgencyMaster() {
        // TODO: 기관명 서비스 검색
        return "";
    }

    // I-5: 연계 서비스 마스터 조회
    @GetMapping("/services")
    public String getReferralServiceMaster() {
        return "";
    }

}
