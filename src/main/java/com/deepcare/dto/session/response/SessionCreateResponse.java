package com.deepcare.dto.session.response;

import com.deepcare.domain.session.Session;

public record SessionCreateResponse(
        String sessionId
) {
    public static SessionCreateResponse from(Session session) {
        return new SessionCreateResponse(session.getId());
    }
}
