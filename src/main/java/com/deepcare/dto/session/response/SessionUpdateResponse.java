package com.deepcare.dto.session.response;

import com.deepcare.domain.session.Session;
import com.deepcare.domain.session.Status;

import java.time.LocalDate;

public record SessionUpdateResponse (
        String id,
        LocalDate date,
        Status status
) {
    public static SessionUpdateResponse from(Session session) {
        return new SessionUpdateResponse(
            session.getId(),
            session.getDate(),
            session.getStatus()
        );
    }
}
