package com.deepcare.dto.client.response;

import com.deepcare.domain.client.Client;

import java.util.List;

public record ClientSearchResponse (
        List<ClientSearchItem> clients
) {
    public static ClientSearchResponse from(List<Client> clients) {
        return new ClientSearchResponse(
                  clients.stream()
                  .map(ClientSearchItem::from)
                  .toList()
        );
    }
}
