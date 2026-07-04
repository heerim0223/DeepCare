package com.deepcare.dto.consultationFlow.request;

import java.util.List;

public record CrisisChecklistUpdateRequest(
        List<Item> checklistItems
) {
    public record Item(
            String id,
            Boolean done
    ) {
    }
}
