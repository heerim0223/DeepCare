package com.deepcare.dto.client.response;

import com.deepcare.domain.client.Client;

public record ClientSearchItem(
        String clientId,
        String name,
        String contactPhone
) {

    public static ClientSearchItem from(Client client) {
        return new ClientSearchItem(
                client.getId(),
                client.getName(),
                client.getContactPhone()
        );
    }
}