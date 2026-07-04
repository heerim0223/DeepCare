package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.CaseStage;

import java.util.List;

public record CaseStageListResponse(
        List<CaseStageResponse> stages
) {
    public static CaseStageListResponse from(List<CaseStage> caseStages) {
        return new CaseStageListResponse(
                caseStages.stream()
                        .map(CaseStageResponse::from)
                        .toList()
        );
    }
}
