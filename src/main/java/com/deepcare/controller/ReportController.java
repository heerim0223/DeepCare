package com.deepcare.controller;

import org.springframework.web.bind.annotation.*;

// 리포트
@RestController
@RequestMapping("/reports")
public class ReportController {

    // RP-1: 리포트 생성 요청
    @PostMapping
    public String callCreateReport() {
        // TODO: 기간별 통계 — 비동기
        return "";
    }

    // RP-2: 리포트 조회
    @GetMapping("/{report_id}")
    public String getReport(@PathVariable("report_id") String reportId) {
        return "";
    }

    // RP-3: 리포트 PDF 내보내기
    @PostMapping("/{report_id}/export")
    public String exportReport(@PathVariable("report_id") String reportId) {
        return "";
    }

}
