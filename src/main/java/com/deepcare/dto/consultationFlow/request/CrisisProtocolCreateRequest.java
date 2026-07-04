package com.deepcare.dto.consultationFlow.request;

import com.deepcare.domain.consultationFlow.CrisisType;

public record CrisisProtocolCreateRequest(
        CrisisType crisisType,
        Boolean notifySupervisor
) {
}
