package controller;

import org.springframework.web.bind.annotation.*;

// 초대코드 관리
@RestController
@RequestMapping("/invitations")
public class InvitationCodeController {

    // INV-1: 초대코드 발급
    @PostMapping
    public String issuance() {
        // TODO: 관리자 전용 — role + org_id 포함
        return "";
    }

    // INV-2: 초대코드 검증
    @GetMapping(path = "/{code}/verify")
    public String verification(@PathVariable String code) {
        // TODO: 비로그인 상태 호출 가능 — 역할·기관명 반환
        return "";
    }

    // INV-3: 초대코드 목록 조회
    @GetMapping
    public String listLookUp() {
        // TODO: 관리자 — 발급 이력 / 사용 여부 확인
        return "";
    }

    // INV-4: 초대코드 취소
    @DeleteMapping(path = "/{code}")
    public String cancellation() {
        // TODO: 미사용 코드 무효화
        return "";
    }

}
