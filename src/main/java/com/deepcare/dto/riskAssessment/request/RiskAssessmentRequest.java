package com.deepcare.dto.riskAssessment.request;

import com.deepcare.domain.riskAssessment.RiskLevel;
import com.deepcare.domain.riskAssessment.RiskType;
import com.deepcare.domain.riskAssessment.SuicideIdeation;

import java.time.LocalDate;
import java.util.List;

// R-2, R-3 공용 요청 DTO (등록 / 수정)
public record RiskAssessmentRequest(
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
        String reportAgency
) {}
