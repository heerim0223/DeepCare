package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.session.SessionParticipant;

import java.util.List;

public record SpeakerConfigResponse(
        List<Speaker> speakers
) {
    public static SpeakerConfigResponse from(List<SessionParticipant> participants) {
        return new SpeakerConfigResponse(
                participants.stream()
                        .map(participant -> new Speaker(
                                participant.getId(),
                                participant.getName(),
                                participant.getClientFamilyMember() == null ? null : participant.getClientFamilyMember().getId(),
                                participant.getSpeakerIndex()
                        ))
                        .toList()
        );
    }

    public record Speaker(
            String participantId,
            String name,
            String familyMemberId,
            Integer speakerIndex
    ) {
    }
}
