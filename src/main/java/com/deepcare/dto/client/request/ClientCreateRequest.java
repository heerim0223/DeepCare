package com.deepcare.dto.client.request;

import com.deepcare.domain.client.AddressType;
import com.deepcare.domain.client.Gender;

import java.time.LocalDate;

public record ClientCreateRequest (
        String name,
        LocalDate birthDate,
        Gender gender,
        String contactPhone,
        String contactSafeTime,
        String address,
        AddressType addressType,
        String nationality,
        Boolean disabilityYn,
        String disabilityType,
        String clientUserId,
        String primaryWorkerUserId,
        LocalDate intakeDate,
        String referralSource
) {}