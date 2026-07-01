package com.deepcare.domain.session;

import lombok.Getter;

@Getter
public enum Method {
    FACE_TO_FACE("대면"),
    PHONE("전화"),
    VIDEO("영상"),
    VISIT("방문");

    private final String description;

    Method(String description) {
        this.description = description;
    }

}