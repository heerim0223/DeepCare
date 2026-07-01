package controller;

import org.springframework.web.bind.annotation.*;

// 가족 구성
@RestController
@RequestMapping("/clients/{client_id}/family")
public class FamilyController {

    // F-1: 가족 구성원 목록 조회
    @GetMapping
    public String getFamilyList() {
        return "";
    }

    // F-2: 가족 구성원 등록
    @PostMapping
    public String createFamily() {
        return "";
    }

    // F-3: 가족 구성원 수정
    @PatchMapping(path = "/{memberId}")
    public String updateFamily(@PathVariable String memberId) {
        return "";
    }

    // F-4: 가족 구성원 삭제
    @DeleteMapping(path = "/{memberId}")
    public String deleteFamily(@PathVariable String memberId) {
        return "";
    }

}
