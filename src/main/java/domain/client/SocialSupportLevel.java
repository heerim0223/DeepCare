package domain.client;

import lombok.Getter;

@Getter
public enum SocialSupportLevel {
    HIGH("강"),
    MEDIUM("중"),
    LOW("약");

    private final String description;

    SocialSupportLevel(String description) {
        this.description = description;
    }

}
