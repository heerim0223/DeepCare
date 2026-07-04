package com.deepcare.dto.client.response;

import com.deepcare.domain.client.Client;
import com.deepcare.domain.riskAssessment.RiskLevel;

public record ClientListItem(
    String id,
    String name,
    String contactPhone,
    RiskLevel riskLevel
) {
    public static ClientListItem of(Client client, RiskLevel riskLevel) {
        return new ClientListItem(
                client.getId(),
                client.getName(),
                client.getContactPhone(),
                riskLevel
        );
    }
}
