package controller;

import org.springframework.web.bind.annotation.*;

// 위험요인 평가
@RestController
@RequestMapping
public class RiskAssessmentController {

    // R-1: 위험요인 평가 조회
    @GetMapping("/sessions/{session_id}/risk")
    public String getRiskAssessment() {
        return "";
    }

    // R-2: 위험요인 평가 등록
    @PostMapping("/sessions/{session_id}/risk")
    public String createRiskAssessment() {
        return "";
    }

    // R-3: 위험요인 평가 수정
    @PatchMapping("/sessions/{session_id}/risk")
    public String updateRiskAssessment() {
        return "";
    }

    // R-4: 위험 클라이언트 목록
    @GetMapping("/clients")
    public String getRiskClientList(@RequestParam String riskLevel) {
        return "";
    }

}
