package com.deepcare.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// 인증 (OAuth Only)
@RestController
public class OauthOnlyController {

    // A-1: OAuth 로그인·가입 콜백
    @PostMapping("/auth/oauth/callback")
    public String oauthCallback() {
        // TODO: 신규 → oauth_token 반환 / 기존 → JWT 발급
        return "";
    }

    // A-2: 사회복지사 가입 완료
    @PostMapping("/users/worker")
    public String createWorker() {
        // TODO: oauth_token + invite_code → role·org 자동 결정
        return "";
    }

    // A-3: 내담자 앱 OAuth 연동
    @PostMapping("/auth/client-link")
    public String linkClient() {
        // TODO: 앱 접근 링크 클릭 후 OAuth 완료 → client_id 연결
        return "";
    }

    // A-4: 토큰 갱신
    @PostMapping("/auth/refresh")
    public String refreshToken() {
        // TODO: JWT Refresh Token → 새 Access Token
        return "";
    }

    // A-5: 로그아웃
    @PostMapping("/auth/logout")
    public String logout() {
        // TODO: Refresh Token 무효화
        return "";
    }

    // A-6: 회원 탈퇴
    @DeleteMapping("/users")
    public String deleteUser() {
        // TODO: 소프트 삭제 + 개인정보 익명화
        return "";
    }

    // A-7: 서버 상태 확인
    @GetMapping("/health")
    public String healthCheck() {
        // TODO: 헬스체크
        return "OK";
    }

}