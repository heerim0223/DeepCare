package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.ProgramApplication;
import com.deepcare.domain.consultationFlow.ProgramStatus;

import java.util.List;

public record ProgramApplicationResponse(
        String applicationId,
        String programId,
        ProgramStatus status,
        List<String> docsRequired,
        List<String> docsSubmitted,
        List<String> docsPending
) {
    public static ProgramApplicationResponse from(ProgramApplication programApplication) {
        return new ProgramApplicationResponse(
                programApplication.getId(),
                programApplication.getProgramId(),
                programApplication.getStatus(),
                programApplication.getDocsRequired(),
                programApplication.getDocsSubmitted(),
                programApplication.getDocsPending()
        );
    }
}
