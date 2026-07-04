package com.deepcare.dto.consultationFlow.request;

import com.deepcare.domain.consultationFlow.ProgramStatus;

public record ProgramStatusChangeRequest(
        ProgramStatus status
) {
}
