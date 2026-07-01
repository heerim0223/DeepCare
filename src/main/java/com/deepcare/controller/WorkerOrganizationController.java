package com.deepcare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// 사회복지사 / 기관
@RestController
public class WorkerOrganizationController {

    // W-1: 사회복지사 목록 조회
    @GetMapping("/workers")
    public String getWorkerList() {
        return "";
    }

    // W-2: 사회복지사 상세 조회
    @GetMapping("/workers/{worker_id}")
    public String getWorkerDetail(@PathVariable("worker_id") String workerId) {
        return "";
    }

    // W-3: 사회복지사 프로필 수정
    @PatchMapping("/workers/{worker_id}")
    public String editWorkerProfile(@PathVariable("worker_id") String workerId) {
        return "";
    }

    // W-4: 담당 케이스 목록
    @GetMapping("/workers/{worker_id}/cases")
    public String getAssignedCaseList(@PathVariable("worker_id") String workerId) {
        return "";
    }

    // W-5: 슈퍼바이저 배정
    @PatchMapping("/clients/{client_id}/supervisor")
    public String assignSupervisor(@PathVariable("client_id") String clientId) {
        // TODO: 슈퍼바이저 관리자 전용
        return "";
    }

    // W-6: 기관 정보 조회
    @GetMapping("/organization")
    public String getOrganization() {
        return "";
    }

    // W-7: 기관 정보 수정
    @PatchMapping("/organization")
    public String editOrganization() {
        // TODO: 관리자 전용
        return "";
    }

}
