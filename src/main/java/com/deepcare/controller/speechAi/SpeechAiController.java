package com.deepcare.controller.speechAi;

import org.springframework.web.bind.annotation.*;

// STT / AI 구조화
@RestController
@RequestMapping("/sessions/{session_id}")
public class SpeechAiController {

    // AI-1: 녹음 파일 업로드
    @PostMapping("/recording")
    public String uploadRecording(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // AI-2: STT 전사 요청
    @PostMapping("/stt")
    public String callStt(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // AI-3: STT 전사 상태 확인
    @GetMapping("/stt/status")
    public String checkSttStatus(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // AI-4: STT 전사 결과 조회
    @GetMapping("/stt/result")
    public String getSttResult(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // AI-5: AI 구조화 요청
    @PostMapping("/ai/structurize")
    public String callAiStructurize(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // AI-6: AI 구조화 초안 조회
    @GetMapping("/ai/draft")
    public String getDraftAi(@PathVariable("session_id") String sessionId) {
        return "";
    }

    // AI-7: AI 초안 확정 (사회복지사 서명)
    @PostMapping("/ai/confirm")
    public String confirmAi(@PathVariable("session_id") String sessionId) {
        return "";
    }

}
