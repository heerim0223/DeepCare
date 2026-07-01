package domain.client;

import lombok.Getter;

@Getter
public enum AddressType {
    OWNER_OCCUPIED("자가"),
    JEONSE("전세"),
    MONTHLY_RENT("월세"),
    HOMELESS("무주택"),
    OTHER("기타");

    private final String description;

    AddressType(String description) {
        this.description = description;
    }

}