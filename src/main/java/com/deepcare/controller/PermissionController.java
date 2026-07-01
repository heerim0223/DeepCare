package com.deepcare.controller;

import org.springframework.web.bind.annotation.*;

// 권한 관리
@RestController
public class PermissionController {

    // PM-1: 클라이언트 공개 항목 조회
    @GetMapping("/clients/{client_id}/permissions")
    public String getClientPublicSection(@PathVariable("client_id") String clientId) {
        return "";
    }

    // PM-2: 클라이언트 공개 항목 설정
    @PatchMapping("/clients/{client_id}/permissions")
    public String setClientPublicSection(@PathVariable("client_id") String clientId) {
        // TODO: 사회복지사 전용 — 필드별 ON/OFF
        return "";
    }

    // PM-3: 역할별 접근 권한 조회
    @GetMapping("/roles/{role}/permissions")
    public String getRolePermissions(@PathVariable("role") String role) {
        // TODO: admin|worker|supervisor|client
        return "";
    }
}