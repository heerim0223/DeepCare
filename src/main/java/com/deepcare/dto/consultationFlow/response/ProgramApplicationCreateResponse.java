package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.ProgramApplication;
import com.deepcare.domain.consultationFlow.ProgramStatus;

import java.util.List;

public record ProgramApplicationCreateResponse(
        String applicationId,
        ProgramStatus status,
        List<String> docsPending
) {
    public static ProgramApplicationCreateResponse from(ProgramApplication programApplication) {
        return new ProgramApplicationCreateResponse(
                programApplication.getId(),
                programApplication.getStatus(),
                programApplication.getDocsPending()
        );
    }
}
