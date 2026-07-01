package com.deepcare.controller;

import org.springframework.web.bind.annotation.*;

// 클라이언트 관리
@RestController
@RequestMapping("/clients")
public class ClientController {

    // C-1: 클라이언트 목록 조회([R-4: 위험 클라이언트 목록] 포함)
    @GetMapping
    public String getClientList(@RequestParam(value = "risk_level", required = false) String riskLevel) {
        // TODO: 담당자·위험도·상태 필터
        return "";
    }

    // C-2: 클라이언트 등록
    @PostMapping
    public String createClient() {
        // TODO: 사회복지사만 가능- 카테고리1 기본 등록
        return "";
    }

    // C-3: 클라이언트 상세 조회
    @GetMapping("/{client_id}")
    public String getClient(@PathVariable("client_id") String clientId) {
        return "";
    }

    // C-4: 클라이언트 정보 수정
    @PatchMapping("/{client_id}")
    public String updateClient(@PathVariable("client_id") String clientId) {
        return "";
    }

    // C-5: 클라이언트 삭제(비활성화)
    @DeleteMapping("/{client_id}")
    public String deactivateClient(@PathVariable("client_id") String clientId) {
        // TODO: 소프트 삭제
        return "";
    }

    // C-6: 클라이언트 검색
    @GetMapping("/search")
    public String searchClient(@RequestParam String q) {
        // TODO: 이름·연락처 검색
        return "";
    }

    // C-7: 내담자 앱 접근 링크 발송
    @PostMapping("/{client_id}/app-access")
    public String sendAccessLink(@PathVariable("client_id") String clientId) {
        // TODO: 사회복지사 → SMS/이메일 발송
        return "";
    }

    // C-8: 내담자 앱 접근 링크 상태 조회
    @GetMapping("/{client_id}/app-access")
    public String getAccessLinkStatus(@PathVariable("client_id") String clientId) {
        // TODO: status: pending | joined | expired
        return "";
    }

}
