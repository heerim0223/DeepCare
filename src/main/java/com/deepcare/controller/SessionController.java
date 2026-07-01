package com.deepcare.controller;

import org.springframework.web.bind.annotation.*;

// 상담 회기
@RestController
public class SessionController {

    // S-1: 회기 목록 조회
    @GetMapping(path = "/clients/{client_id}/sessions")
    public String getSessionList(@PathVariable("client_id") String clientId) {
        return "";
    }

    // S-2: 회기 등록 (상담 시작)
    @PostMapping(path = "/clients/{client_id}/sessions")
    public String createSession(@PathVariable("client_id") String clientId) {
        // TODO: 상담 유형 선택 → 플로우 자동 결정
        return "";
    }

    // S-3: 회기 상세
    @GetMapping(path = "/sessions/{session_id}")
    public String getSession(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // S-4: 회기 수정
    @PatchMapping(path = "/sessions/{session_id}")
    public String updateSession(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // S-5: 회기 삭제
    @DeleteMapping(path = "/sessions/{session_id}")
    public String removeSession(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // S-6: 예정 상담 일정 조회
    @GetMapping(path = "/sessions/upcoming")
    public String getUpcomingSession(@RequestParam("worker_id") String workerId) {
        // TODO: 사회복지사 캘린더
        return "";
    }

}
