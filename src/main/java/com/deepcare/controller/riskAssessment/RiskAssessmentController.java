package com.deepcare.controller.riskAssessment;

import com.deepcare.dto.riskAssessment.request.RiskAssessmentRequest;
import com.deepcare.dto.riskAssessment.response.RiskAssessmentCreateResponse;
import com.deepcare.dto.riskAssessment.response.RiskAssessmentResponse;
import com.deepcare.service.riskAssessment.RiskAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 위험요인 평가
@RestController
@RequiredArgsConstructor
public class RiskAssessmentController {

    private final RiskAssessmentService riskAssessmentService;

    // R-1: 위험요인 평가 조회
    @GetMapping("/sessions/{session_id}/risk")
    public ResponseEntity<RiskAssessmentResponse> getRiskAssessment(@PathVariable("session_id") String sessionId) {
        return ResponseEntity.ok(
                riskAssessmentService.getRiskAssessment(sessionId)
        );
    }

    // R-2: 위험요인 평가 등록
    @PostMapping("/sessions/{session_id}/risk")
    public ResponseEntity<RiskAssessmentCreateResponse> createRiskAssessment(
            @PathVariable("session_id") String sessionId,
            @RequestBody RiskAssessmentRequest request
    ) {
        // risk_level=high 시 Push 알림 자동 발송 (RiskAssessmentService에서 처리)
        return ResponseEntity.status(HttpStatus.CREATED).body(
                riskAssessmentService.createRiskAssessment(sessionId, request)
        );
    }

    // R-3: 위험요인 평가 수정
    @PatchMapping("/sessions/{session_id}/risk")
    public ResponseEntity<RiskAssessmentResponse> updateRiskAssessment(
            @PathVariable("session_id") String sessionId,
            @RequestBody RiskAssessmentRequest request
    ) {
        return ResponseEntity.ok(
                riskAssessmentService.updateRiskAssessment(sessionId, request)
        );
    }

}
