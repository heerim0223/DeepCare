package com.deepcare.dto.client.response;

import com.deepcare.domain.client.AddressType;
import com.deepcare.domain.client.Client;
import com.deepcare.domain.client.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClientGetResponse (
        String id,
        String clientUserId,
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
        String primaryWorkerUserId,
        LocalDate intakeDate,
        String referralSource,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ClientGetResponse from(Client client) {
        return new ClientGetResponse(
                client.getId(),
                client.getClientUser() == null ? null : client.getClientUser().getId(),
                client.getName(),
                client.getBirthDate(),
                client.getGender(),
                client.getContactPhone(),
                client.getContactSafeTime(),
                client.getAddress(),
                client.getAddressType(),
                client.getNationality(),
                client.getDisabilityYn(),
                client.getDisabilityType(),
                client.getPrimaryWorker().getId(),
                client.getIntakeDate(),
                client.getReferralSource(),
                client.getCreatedAt(),
                client.getUpdatedAt()
        );
    }
}
