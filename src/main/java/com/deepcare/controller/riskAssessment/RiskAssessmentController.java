package com.deepcare.controller.riskAssessment;

import org.springframework.web.bind.annotation.*;

// 위험요인 평가
@RestController
@RequestMapping
public class RiskAssessmentController {

    // R-1: 위험요인 평가 조회
    @GetMapping("/sessions/{session_id}/risk")
    public String getRiskAssessment(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // R-2: 위험요인 평가 등록
    @PostMapping("/sessions/{session_id}/risk")
    public String createRiskAssessment(@PathVariable("session_id") String sessionId) {
        // TODO: risk_level=high 시 Push 알림 자동 발송
        return "";
    }

    // R-3: 위험요인 평가 수정
    @PatchMapping("/sessions/{session_id}/risk")
    public String updateRiskAssessment(@PathVariable("session_id") String sessionId) {
        return "";
    }

}
