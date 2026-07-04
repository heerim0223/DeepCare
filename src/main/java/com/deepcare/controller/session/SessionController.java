package com.deepcare.controller.session;

import com.deepcare.dto.session.request.SessionCreateRequest;
import com.deepcare.dto.session.request.SessionUpdateRequest;
import com.deepcare.dto.session.response.*;
import com.deepcare.service.session.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 상담 회기
@RestController
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    // S-1: 회기 목록 조회
    @GetMapping(path = "/clients/{client_id}/sessions")
    public ResponseEntity<SessionListGetResponse> getSessionList(@PathVariable("client_id") String clientId) {
        return ResponseEntity.ok(
                sessionService.getSessionList(clientId)
        );
    }

    // S-2: 회기 등록 (상담 시작)
    @PostMapping(path = "/clients/{client_id}/sessions")
    public ResponseEntity<SessionCreateResponse> createSession(
            @PathVariable("client_id") String clientId,
            @RequestBody SessionCreateRequest request
    ) {
        // TODO: 상담 유형 선택 → 플로우 자동 결정
        return ResponseEntity.ok(
                sessionService.createSession(clientId, request)
        );
    }

    // S-3: 회기 상세
    @GetMapping(path = "/sessions/{session_id}")
    public ResponseEntity<GetSessionResponse> getSession(@PathVariable("session_id") String sessionId) {
        return ResponseEntity.ok(
                sessionService.getSession(sessionId)
        );
    }

    // S-4: 회기 수정
    @PatchMapping(path = "/sessions/{session_id}")
    public ResponseEntity<SessionUpdateResponse> updateSession(
            @PathVariable("session_id") String sessionId,
            @RequestBody SessionUpdateRequest request
            ) {
        return ResponseEntity.ok(
                sessionService.updateSession(sessionId, request)
        );
    }

    // S-5: 회기 삭제
    @DeleteMapping(path = "/sessions/{session_id}")
    public ResponseEntity<Void> removeSession(@PathVariable("session_id") String sessionId) {
        sessionService.removeSession(sessionId);

        return ResponseEntity.noContent().build();
    }

    // S-6: 예정 상담 일정 조회
    @GetMapping(path = "/sessions/upcoming")
    public ResponseEntity<SessionUpcomingGetResponse> getUpcomingSession(@RequestParam("worker_id") String workerId) {
        // TODO: 사회복지사 캘린더
        return ResponseEntity.ok(
                sessionService.getUpcomingSession(workerId)
        );
    }

}
