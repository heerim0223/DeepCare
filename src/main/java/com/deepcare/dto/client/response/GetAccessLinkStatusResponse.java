package com.deepcare.dto.client.response;

import com.deepcare.domain.accessLink.AccessLink;
import com.deepcare.domain.accessLink.Status;

public record GetAccessLinkStatusResponse (
        String id,
        Status status
) {
    public static GetAccessLinkStatusResponse from(AccessLink accessLink) {
        return new GetAccessLinkStatusResponse(
                accessLink.getId(),
                accessLink.getStatus()
        );
    }
}
