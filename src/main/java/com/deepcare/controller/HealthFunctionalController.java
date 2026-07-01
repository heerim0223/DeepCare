package com.deepcare.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients/{client_id}/health")
public class HealthFunctionalController {

    // H-1: 건강상태 조회
    @GetMapping
    public String getHealthStatus(@PathVariable("client_id") String clientId) {
        return "";
    }

    // H-2: 건강 상태 등록
    @PostMapping
    public String createHealthStatus(@PathVariable("client_id") String clientId) {
        // TODO: rPPG 생체 데이터 포함
        return "";
    }

    // H-3: 건강 상태 수정
    @PatchMapping(path = "/{record_id}")
    public String updateHealthStatus(
            @PathVariable("client_id") String clientId,
            @PathVariable("record_id") String recordId
    ) {
        return "";
    }

    // H-4: 건강 상태 기간별 조회
    @GetMapping(params = { "from", "to" })
    public String getHealthStatusByPeriod(
            @PathVariable("client_id") String ClientId,
            @RequestParam String from,
            @RequestParam String to
    ) {
        // TODO:
        return "";
    }

}
