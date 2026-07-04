package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.CaseStage;
import com.deepcare.domain.consultationFlow.CaseStageType;

public record CaseStageCreateResponse(
        String stageId,
        CaseStageType stage,
        Integer progressPct
) {
    public static CaseStageCreateResponse from(CaseStage caseStage) {
        return new CaseStageCreateResponse(
                caseStage.getId(),
                caseStage.getStage(),
                caseStage.getStageProgressPct()
        );
    }
}
