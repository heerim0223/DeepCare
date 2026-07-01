package controller;

import org.springframework.web.bind.annotation.*;

// 클라이언트 관리
@RestController
@RequestMapping("/clients")
public class ClientController {

    // C-1: 클라이언트 목록 조회
    @GetMapping
    public String getClientList() {
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
    @GetMapping(path = "/{clientId}")
    public String getClient(@PathVariable String clientId) {
        return "";
    }

    // C-4: 클라이언트 정보 수정
    public String updateClient() {
        return "";
    }

    // C-5: 클라이언트 삭제(비활성화)
    public String deactivateClient() {
        // TODO: 소프트 삭제
        return "";
    }

    // C-6: 클라이언트 검색
    public String searchClient() {
        // TODO: 이름·연락처 검색
        return "";
    }

    // C-7: 내담자 앱 접근 링크 발송
    public String sendAccessLink() {
        // TODO: 사회복지사 → SMS/이메일 발송
        return "";
    }

    // C-8: 내담자 앱 접근 링크 상태 조회
    public String getAccessLinkStatus() {
        // TODO: status: pending | joined | expired
        return "";
    }

}
