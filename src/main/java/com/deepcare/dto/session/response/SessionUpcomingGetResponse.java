package com.deepcare.dto.session.response;

import java.util.List;

public record SessionUpcomingGetResponse(
        List<SessionUpcomingItem> sessions
) {
    public static SessionUpcomingGetResponse of(List<SessionUpcomingItem> sessions) {
        return new SessionUpcomingGetResponse(sessions);
    }
}
