package com.deepcare.controller.economicStatus;

import org.springframework.web.bind.annotation.*;

// 경제 상황
@RestController
@RequestMapping("/clients/{client_id}/economic")
public class EconomicStatusController {

    // E-1: 경제 상태 조회
    @GetMapping
    public String getEconomicStatus(@PathVariable("client_id") String clientId) {
        return "";
    }

    // E-2: 경제 상태 등록
    @PostMapping
    public String createdEconomicStatus(@PathVariable("client_id") String clientId) {
        return "";
    }

    // E-3: 경제 상태 수정
    @PatchMapping
    public String updateEconomicStatus(@PathVariable("client_id") String clientId) {
        return "";
    }

}
