package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.ProgramApplication;

import java.util.List;

public record ProgramApplicationListResponse(
        List<ProgramApplicationResponse> programs
) {
    public static ProgramApplicationListResponse from(List<ProgramApplication> programApplications) {
        return new ProgramApplicationListResponse(
                programApplications.stream()
                        .map(ProgramApplicationResponse::from)
                        .toList()
        );
    }
}
