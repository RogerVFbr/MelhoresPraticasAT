package com.soundlab.core.subject.aggregate.enums;

public enum StudyShift {
    MORNING (0, "Morning"),
    AFTERNOON (1, "Afternoon"),
    EVENING (2, "Evening");

    private final int id;
    private final String description;

    StudyShift(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static StudyShift forValue(int id) {
        StudyShift[] values = values();
        for (StudyShift studyShift : values) {
            if (studyShift.id == id) {
                return studyShift;
            }
        }
        return null;
    }
}
