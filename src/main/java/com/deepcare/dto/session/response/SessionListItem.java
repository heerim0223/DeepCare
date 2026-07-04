package com.deepcare.dto.session.response;

import com.deepcare.domain.session.Method;
import com.deepcare.domain.session.Session;
import com.deepcare.domain.session.Status;
import com.deepcare.domain.session.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SessionListItem(
        String id,
        Integer number,
        LocalDate date,
        LocalDateTime timeStart,
        LocalDateTime timeEnd,
        Method method,
        Type type,
        Status status,
        String workerUserId
) {
    public static SessionListItem from(Session session) {
        return new SessionListItem(
                session.getId(),
                session.getNumber(),
                session.getDate(),
                session.getTimeStart(),
                session.getTimeEnd(),
                session.getMethod(),
                session.getType(),
                session.getStatus(),
                session.getWorkerUser() == null ? null : session.getWorkerUser().getId()
        );
    }
}
