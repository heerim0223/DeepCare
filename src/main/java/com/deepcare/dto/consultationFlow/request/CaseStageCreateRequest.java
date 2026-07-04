package com.deepcare.dto.consultationFlow.request;

import com.deepcare.domain.consultationFlow.CaseStageType;

import java.util.List;

public record CaseStageCreateRequest(
        CaseStageType stage,
        List<String> goals
) {
}
