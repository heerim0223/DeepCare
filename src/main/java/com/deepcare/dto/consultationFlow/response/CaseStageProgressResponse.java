package com.deepcare.dto.consultationFlow.response;

public record CaseStageProgressResponse(
        Integer totalGoals,
        Integer achieved,
        Integer progressPct
) {
    public static CaseStageProgressResponse of(int totalGoals, int achieved) {
        int progressPct = totalGoals == 0 ? 0 : (int) Math.round(achieved * 100.0 / totalGoals);
        return new CaseStageProgressResponse(totalGoals, achieved, progressPct);
    }
}
