package com.deepcare.controller.client;

import com.deepcare.dto.client.request.ClientCreateRequest;
import com.deepcare.dto.client.request.ClientUpdateRequest;
import com.deepcare.dto.client.response.*;
import com.deepcare.service.client.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 클라이언트 관리
@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    // C-1: 클라이언트 목록 조회([R-4: 위험 클라이언트 목록] 포함)
    @GetMapping
    public ResponseEntity<ClientListGetResponse> getClientList(@RequestParam(value = "risk_level", required = false) String riskLevel) {
        // TODO: 담당자·위험도·상태 필터
        return ResponseEntity.ok(
                clientService.getClientList(riskLevel)
        );
    }

    // C-2: 클라이언트 등록
    @PostMapping
    public ResponseEntity<ClientCreateResponse> createClient(@RequestBody ClientCreateRequest request) {
        // TODO: 사회복지사만 가능- 카테고리1 기본 등록
        return ResponseEntity.ok(
                clientService.createClient(request)
        );
    }

    // C-3: 클라이언트 상세 조회
    @GetMapping("/{client_id}")
    public ResponseEntity<ClientGetResponse> getClient(@PathVariable("client_id") String clientId) {
        return ResponseEntity.ok(
                clientService.getClient(clientId)
        );
    }

    // C-4: 클라이언트 정보 수정
    @PatchMapping("/{client_id}")
    public ResponseEntity<ClientUpdateResponse> updateClient(
            @PathVariable("client_id") String clientId,
            @RequestBody ClientUpdateRequest request
            ) {
        return ResponseEntity.ok(
                clientService.updateClient(clientId, request)
        );
    }

    // C-5: 클라이언트 삭제(비활성화)
    @DeleteMapping("/{client_id}")
    public ResponseEntity<Void> deactivateClient(@PathVariable("client_id") String clientId) {
        // TODO: 소프트 삭제
        clientService.deactivateClient(clientId);

        return ResponseEntity.noContent().build();
    }

    // C-6: 클라이언트 검색
    @GetMapping("/search")
    public ResponseEntity<ClientSearchResponse> searchClient(@RequestParam String q) {
        // TODO: 이름·연락처 검색
        return ResponseEntity.ok(
                clientService.searchClient(q)
        );
    }

    // C-7: 내담자 앱 접근 링크 발송
    @PostMapping("/{client_id}/app-access")
    public ResponseEntity<SendAccessLinkResponse> sendAccessLink(@PathVariable("client_id") String clientId) {
        // TODO: 사회복지사 → SMS/이메일 발송
        return ResponseEntity.ok(
                clientService.sendAccessLink(clientId)
        );
    }

    // C-8: 내담자 앱 접근 링크 상태 조회
    @GetMapping("/{client_id}/app-access")
    public ResponseEntity<GetAccessLinkStatusResponse> getAccessLinkStatus(@PathVariable("client_id") String clientId) {
        // TODO: status: pending | joined | expired
        return ResponseEntity.ok(
                clientService.getAccessLinkStatus(clientId)
        );
    }

}
