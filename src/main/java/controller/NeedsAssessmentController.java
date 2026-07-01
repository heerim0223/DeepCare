package controller;

import org.springframework.web.bind.annotation.*;

// 욕구 평가
@RestController
@RequestMapping("/sessions/{session_id}/needs")
public class NeedsAssessmentController {

    // N-1: 욕구 평가 조회
    @GetMapping
    public String getNeedsAssessment() {
        return "";
    }

    // N-2: 욕구 평가 등록
    @PostMapping
    public String createNeedsAssessment() {
        return "";
    }

    // N-3: 욕구 평가 수정
    @PatchMapping
    public String updateNeedsAssessment() {
        return "";
    }
}