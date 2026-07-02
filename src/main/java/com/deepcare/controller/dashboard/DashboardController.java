package com.deepcare.controller.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 대시보드
@RestController
public class DashboardController {

    // DB-1: 클라이언트 대시보드 요약
    @GetMapping("/clients/{client_id}/dashboard")
    public String getClientDashboardSummary(@PathVariable("client_id") String clientId) {
        return "";
    }

    // DB-2: 혈압·심박 변화 추이
    @GetMapping("/clients/{client_id}/dashboard/vitals")
    public String getVitalTrend(
            @PathVariable("client_id") String clientId,
            @RequestParam("unit") String unit) {
        // TODO: session|week|month|quarter
        return "";
    }

    // DB-3: 감정 변화 추이(영역 차트)
    @GetMapping("/clients/{client_id}/dashboard/emotions")
    public String getEmotionTrend(
            @PathVariable("client_id") String clientId,
            @RequestParam("unit") String unit) {
        return "";
    }

    // DB-4: 스트레스 지수 변화(막대)
    @GetMapping("/clients/{client_id}/dashboard/stress")
    public String getStressTrend(
            @PathVariable("client_id") String clientId,
            @RequestParam("unit") String unit
    ) {
        // TODO: 임계선 80 — 위험 신호
        return "";
    }

    // DB-5: 상담 목표 달성률(도넛)
    @GetMapping("/clients/{client_id}/dashboard/goals")
    public String getGoalAchievement(@PathVariable("client_id") String clientId) {
        return "";
    }

    // DB-6: 서비스 연계 타임라인
    @GetMapping("/clients/{client_id}/dashboard/referrals")
    public String getReferralTimeline(@PathVariable("client_id") String clientId) {
        return "";
    }

    // DB-7: 위험 신호 발생 이력(달력)
    @GetMapping("/clients/{client_id}/dashboard/risk-history")
    public String getRiskHistory(@PathVariable("client_id") String clientId) {
        return "";
    }

    // DB-8: 기관 전체 통계
    @GetMapping("/dashboard/organization")
    public String getOrganizationDashboard() {
        // TODO: 관리자 전용
        return "";
    }

}