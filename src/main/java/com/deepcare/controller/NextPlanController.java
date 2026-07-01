package com.deepcare.controller;

import org.springframework.web.bind.annotation.*;

// 차기 계획
@RestController
@RequestMapping("/sessions/{session_id}/next-plan")
public class NextPlanController {

    // NP-1: 차기 계획 조회
    @GetMapping
    public String getNextPlan(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // NP-2: 차기 계획 등록
    @PostMapping
    public String createNextPlan(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // NP-3: 차기 계획 수정
    @PatchMapping
    public String updateNextPlan(@PathVariable("session_id") String sessionId) {
        return "";
    }

}
