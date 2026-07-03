package com.deepcare.dto.client.response;

import com.deepcare.domain.accessLink.AccessLink;
import com.deepcare.domain.client.Client;

public record SendAccessLinkResponse(
        String clientId,
        AccessLink accessLink,
        String message
) {
    public static SendAccessLinkResponse from(Client client, AccessLink accessLink) {
        return new SendAccessLinkResponse(
                client.getId(),
                accessLink,
                "접근 링크가 발송되었습니다."
        );
    }
}