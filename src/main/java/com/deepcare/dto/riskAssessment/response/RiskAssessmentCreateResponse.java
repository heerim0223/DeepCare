package com.deepcare.dto.riskAssessment.response;

import com.deepcare.domain.riskAssessment.RiskAssessment;
import com.deepcare.domain.riskAssessment.RiskLevel;

// R-2: 위험요인 평가 등록 응답
// alertSent=true → 슈퍼바이저·관리자 Push 자동 발송
public record RiskAssessmentCreateResponse(
        String riskId,
        RiskLevel riskLevel,
        boolean alertSent
) {
    public static RiskAssessmentCreateResponse of(RiskAssessment riskAssessment, boolean alertSent) {
        return new RiskAssessmentCreateResponse(
                riskAssessment.getId(),
                riskAssessment.getRiskLevel(),
                alertSent
        );
    }
}
