package com.soundlab.core.user.aggregate.enums;

import com.soundlab.core.subject.aggregate.enums.StudyShift;

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

    public static PhoneType forValue(int id) {
        PhoneType[] values = values();
        for (PhoneType phoneType : values) {
            if (phoneType.id == id) {
                return phoneType;
            }
        }
        return null;
    }
}
