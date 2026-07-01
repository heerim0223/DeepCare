package com.deepcare.domain.client;

import lombok.Getter;

@Getter
public enum CohabitationStatus {
    COHABITING("동거"),
    NOT_COHABITING("비동거"),
    UNKNOWN("미상");

    private final String description;

    CohabitationStatus(String description) {
        this.description = description;
    }
}