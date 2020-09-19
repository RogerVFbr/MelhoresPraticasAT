package com.soundlab.core.user.aggregate.enums;

import lombok.Getter;

@Getter
public enum PhoneType {
    LANDLINE(0, "Landline"),
    MOBILE(1, "Mobile");

    private final int id;
    private final String description;

    PhoneType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
