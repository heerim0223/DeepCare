package com.deepcare.dto.consultationFlow.response;

import com.deepcare.domain.consultationFlow.CrisisProtocol;
import com.deepcare.domain.notification.Notification;

import java.util.List;

public record CrisisProtocolCreateResponse(
        String protocolId,
        String checklistUrl,
        List<String> notified
) {
    public static CrisisProtocolCreateResponse of(CrisisProtocol crisisProtocol, List<Notification> notifications) {
        return new CrisisProtocolCreateResponse(
                crisisProtocol.getId(),
                "/sessions/" + crisisProtocol.getSession().getId() + "/crisis-checklist",
                notifications.stream()
                        .map(notification -> notification.getUser().getName())
                        .toList()
        );
    }
}
