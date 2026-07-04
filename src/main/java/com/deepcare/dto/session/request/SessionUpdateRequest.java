package com.deepcare.dto.session.request;

import com.deepcare.domain.session.Method;
import com.deepcare.domain.session.Status;
import com.deepcare.domain.session.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SessionUpdateRequest (
        Integer number,
        LocalDate sessionDate,
        LocalDateTime timeStart,
        LocalDateTime timeEnd,
        Integer durationMin,
        Method method,
        Type type,
        Status status
) {}
