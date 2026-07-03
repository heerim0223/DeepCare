package com.deepcare.dto.client.response;

import com.deepcare.domain.client.Client;

import java.util.List;

public record ClientListGetResponse (
        List<ClientListItem> clients
) {
    public static ClientListGetResponse from(List<Client> clients) {
        return new ClientListGetResponse(
                clients.stream()
                        .map(ClientListItem::from)
                        .toList()
        );
    }
}
