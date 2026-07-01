package com.deepcare.domain.session;

import lombok.Getter;

@Getter
public enum Type {
    INDIVIDUAL("개인"),
    FAMILY("가족"),
    GROUP("집단"),
    CRISIS("위기"),
    CASE_MANAGEMENT("사례관리"),
    PROGRAM_APPLICATION("프로그램신청");

    private final String description;

    Type(String description) {
        this.description = description;
    }

}