package com.deepcare.controller.family;

import org.springframework.web.bind.annotation.*;

// 가족 구성
@RestController
@RequestMapping("/clients/{client_id}/family")
public class FamilyController {

    // F-1: 가족 구성원 목록 조회
    @GetMapping
    public String getFamilyList(@PathVariable("client_id") String clientId) {
        return "";
    }

    // F-2: 가족 구성원 등록
    @PostMapping
    public String createFamily(@PathVariable("client_id") String clientId) {
        return "";
    }

    // F-3: 가족 구성원 수정
    @PatchMapping("/{member_id}")
    public String updateFamily(
            @PathVariable("client_id") String clientId,
            @PathVariable("member_id") String memberId
    ) {
        return "";
    }

    // F-4: 가족 구성원 삭제
    @DeleteMapping("/{member_id}")
    public String deleteFamily(
            @PathVariable("client_id") String clientId,
            @PathVariable("member_id") String memberId
    ) {
        return "";
    }

}
