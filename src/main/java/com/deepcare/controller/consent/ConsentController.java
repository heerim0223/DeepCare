package com.deepcare.controller.consent;

import org.springframework.web.bind.annotation.*;

// 동의 관리
@RestController
@RequestMapping("/clients/{client_id}/consents")
public class ConsentController {

    // CON-1: 동의 정보 조회
    @GetMapping
    public String getConsent(@PathVariable("client_id") String clientId) {
        return "";
    }

    // CON-2: 동의 등록
    @PostMapping
    public String createConsent(@PathVariable("client_id") String clientId) {
        // TODO: 녹음·민감정보·제3자·카메라 동의
        return "";
    }

    // CON-3: 동의 수정 / 철회
    @PatchMapping("/{consent_id}")
    public String updateConsent(
            @PathVariable("client_id") String clientId,
            @PathVariable("consent_id") String consentId
    ) {
        return "";
    }

}
