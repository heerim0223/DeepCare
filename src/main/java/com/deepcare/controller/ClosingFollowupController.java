package com.deepcare.controller;

import org.springframework.web.bind.annotation.*;

// 종결 및 사후관리
@RestController
@RequestMapping("/clients/{client_id}")
public class ClosingFollowupController {

    // CL-1: 종결 정보 조회
    @GetMapping("/closing")
    public String getClosing(@PathVariable("client_id") String clientId) {
        return "";
    }

    // CL-2: 종결 정보 등록
    @PostMapping("/closing")
    public String createClosing(@PathVariable("client_id") String clientId) {
        return "";
    }

    // CL-3: 종결 정보 수정
    @PatchMapping("/closing")
    public String updateClosing(@PathVariable("client_id") String clientId) {
        return "";
    }

    // CL-4: 사후관리 목록 조회
    @GetMapping("/aftercare")
    public String getFollowupList(@PathVariable("client_id") String clientId) {
        return "";
    }

    // CL-5: 종결 요약 AI 초안 생성
    @PostMapping("/closing/summary")
    public String createClosingAi(@PathVariable("client_id") String clientId) {
        // TODO: 누적 기록 기반 LLM 자동 작성
        return "";
    }

}
