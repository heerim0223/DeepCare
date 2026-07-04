package com.deepcare.dto.session.response;

import com.deepcare.domain.session.Method;
import com.deepcare.domain.session.Session;
import com.deepcare.domain.session.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SessionUpcomingItem(
        String id,
        String clientId,
        String clientName,
        LocalDate date,
        LocalDateTime timeStart,
        LocalDateTime timeEnd,
        Method method,
        Type type
) {
    public static SessionUpcomingItem from(Session session) {
        return new SessionUpcomingItem(
                session.getId(),
                session.getClient().getId(),
                session.getClient().getName(),
                session.getDate(),
                session.getTimeStart(),
                session.getTimeEnd(),
                session.getMethod(),
                session.getType()
        );
    }
}
