package com.deepcare.dto.client.request;

import com.deepcare.domain.client.Gender;

import java.time.LocalDate;

public record ClientUpdateRequest (
        String name,
        LocalDate birthDate,
        Gender gender,
        String contactPhone,
        String address,
        String nationality,
        Boolean disabilityYn,
        String disabilityType
) {}
