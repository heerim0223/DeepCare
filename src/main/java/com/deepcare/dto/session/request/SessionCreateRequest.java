package com.deepcare.dto.session.request;

import com.deepcare.domain.session.Method;
import com.deepcare.domain.session.Status;
import com.deepcare.domain.session.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SessionCreateRequest (
        String clientID,
        LocalDate sessionDate,
        LocalDateTime timeStart,
        LocalDateTime timeEnd,
        Integer durationMin,
        Method method,
        String location,
        Type type,
        Integer number,
        String workerUserId,
        Status status,
        LocalDateTime signedAt
) {}
