package com.deepcare.dto.client.response;

import java.util.List;

public record ClientListGetResponse (
        List<ClientListItem> clients
) {
    public static ClientListGetResponse of(List<ClientListItem> clients) {
        return new ClientListGetResponse(clients);
    }
}
