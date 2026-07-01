package controller;

import org.springframework.web.bind.annotation.*;

// 상담 주제
@RestController
@RequestMapping("/session/{sessionId}/topic")
public class SessionTopicController {

    // T-1: 상담 주제 조회
    @GetMapping
    public String getSessionTopic() {
        return "";
    }

    // T-2: 상담 주제 등록
    @PostMapping
    public String createSessionTopic() {
        // TODO: AI 자동 추출 초안 또는 수동
        return "";
    }

    // T-3: 상담 주제 수정
    @PatchMapping
    public String updateSessionTopic() {
        return "";
    }

}
