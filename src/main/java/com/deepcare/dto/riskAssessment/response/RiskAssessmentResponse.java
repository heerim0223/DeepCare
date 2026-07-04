package com.deepcare.dto.riskAssessment.response;

import com.deepcare.domain.riskAssessment.RiskAssessment;
import com.deepcare.domain.riskAssessment.RiskLevel;
import com.deepcare.domain.riskAssessment.RiskType;
import com.deepcare.domain.riskAssessment.SuicideIdeation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// R-1: 위험요인 평가 조회 / R-3: 수정 응답
public record RiskAssessmentResponse(
        String id,
        String sessionId,
        Boolean riskFlag,
        List<RiskType> riskType,
        RiskLevel riskLevel,
        SuicideIdeation suicideIdeation,
        Boolean selfHarmYn,
        Boolean abuseSuspicionYn,
        Boolean dvYn,
        Boolean substanceUseYn,
        Boolean neglectYn,
        String riskActionTaken,
        Boolean reportYn,
        LocalDate reportDate,
        String reportAgency,
        LocalDateTime createdAt
) {
    public static RiskAssessmentResponse from(RiskAssessment riskAssessment) {
        return new RiskAssessmentResponse(
                riskAssessment.getId(),
                riskAssessment.getSession().getId(),
                riskAssessment.getRiskFlag(),
                riskAssessment.getRiskTypes(),
                riskAssessment.getRiskLevel(),
                riskAssessment.getSuicideIdeation(),
                riskAssessment.getSelfHarmYn(),
                riskAssessment.getAbuseSuspicionYn(),
                riskAssessment.getDvYn(),
                riskAssessment.getSubstanceUseYn(),
                riskAssessment.getNeglectYn(),
                riskAssessment.getRiskActionTaken(),
                riskAssessment.getReportYn(),
                riskAssessment.getReportDate(),
                riskAssessment.getReportAgency(),
                riskAssessment.getCreatedAt()
        );
    }
}
