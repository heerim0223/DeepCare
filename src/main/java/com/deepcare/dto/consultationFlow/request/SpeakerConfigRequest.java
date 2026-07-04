package com.deepcare.dto.consultationFlow.request;

import java.util.List;

public record SpeakerConfigRequest(
        List<String> speakers
) {
}
