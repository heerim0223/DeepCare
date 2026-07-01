package controller;

import org.springframework.web.bind.annotation.*;

// 상담 회기
@RestController
public class SessionController {

    // S-1: 회기 목록 조회
    @GetMapping(path = "/clients/{clientId}/sessions")
    public String getSessionList(@PathVariable String clientId) {
        return "";
    }

    // S-2: 회기 등록 (상담 시작)
    @PostMapping(path = "/clients/{clientId}/sessions")
    public String createSession(@PathVariable String clientId) {
        // TODO: 상담 유형 선택 → 플로우 자동 결정
        return "";
    }

    // S-3: 회기 상세
    @GetMapping(path = "/sessions/{sessionId}")
    public String getSession(@PathVariable String sessionId) {
        return "";
    }

    // S-4: 회기 수정
    @PatchMapping(path = "/sessions/{sessionId}")
    public String updateSession(@PathVariable String sessionId) {
        return "";
    }

    // S-5: 회기 삭제
    @DeleteMapping(path = "/sessions/{sessionId}")
    public String removeSession(@PathVariable String sessionId) {
        return "";
    }

    // S-6: 예정 상담 일정 조회
    @GetMapping(path = "/sessions/upcoming")
    public String getUpcomingSession(@RequestParam String workerId) {
        // TODO: 사회복지사 캘린더
        return "";
    }

}
