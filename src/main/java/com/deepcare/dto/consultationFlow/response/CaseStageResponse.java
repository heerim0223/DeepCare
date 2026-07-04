package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.CaseStage;
import com.deepcare.domain.consultationFlow.CaseStageType;

import java.util.List;

public record CaseStageResponse(
        String stageId,
        CaseStageType stage,
        List<Goal> goals
) {
    public static CaseStageResponse from(CaseStage caseStage) {
        return new CaseStageResponse(
                caseStage.getId(),
                caseStage.getStage(),
                caseStage.getGoals().stream()
                        .map(goal -> new Goal(goal.getId(), goal.getDescription(), goal.getAchieved()))
                        .toList()
        );
    }

    public record Goal(
            String goalId,
            String description,
            Boolean achieved
    ) {
    }
}
