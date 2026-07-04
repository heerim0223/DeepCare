package com.deepcare.dto.session.response;

import java.util.List;

public record SessionListGetResponse(
        List<SessionListItem> sessions
) {
    public static SessionListGetResponse of(List<SessionListItem> sessions) {
        return new SessionListGetResponse(sessions);
    }
}
