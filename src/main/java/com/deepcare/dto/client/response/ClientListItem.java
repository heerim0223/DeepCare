package com.deepcare.dto.client.response;

import com.deepcare.domain.client.Client;

// TODO: RiskLevel 필드 추가
public record ClientListItem(
    String id,
    String name,
    String contactPhone
) {
    public static ClientListItem from(Client client) {
        return new ClientListItem(
                client.getId(),
                client.getName(),
                client.getContactPhone()
        );
    }
}
