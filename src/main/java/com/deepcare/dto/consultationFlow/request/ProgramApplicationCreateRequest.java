package com.deepcare.dto.consultationFlow.request;

import java.util.List;

public record ProgramApplicationCreateRequest(
        String programId,
        List<String> docsRequired
) {
}
