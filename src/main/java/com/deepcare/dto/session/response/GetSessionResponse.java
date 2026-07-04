package com.deepcare.dto.session.response;

import com.deepcare.domain.client.Client;
import com.deepcare.domain.session.Method;
import com.deepcare.domain.session.Session;
import com.deepcare.domain.session.Status;
import com.deepcare.domain.session.Type;
import com.deepcare.domain.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record GetSessionResponse (
        String id,
        Client client,
        LocalDate date,
        LocalDateTime timeStart,
        LocalDateTime timeEnd,
        Integer durationMin,
        Method method,
        Type type,
        Integer number,
        User workerUser,
        String supervisorUSer,
        Status status
) {
    public static GetSessionResponse from(Session session) {
        return new GetSessionResponse(
            session.getId(),
            session.getClient(),
            session.getDate(),
            session.getTimeStart(),
            session.getTimeEnd(),
            session.getDurationMin(),
            session.getMethod(),
            session.getType(),
            session.getNumber(),
            session.getWorkerUser(),
            session.getSupervisorUser() == null ? null : session.getSupervisorUser().getId(),
            session.getStatus()
        );
    }
}
