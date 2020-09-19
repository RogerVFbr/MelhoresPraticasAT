package com.soundlab.core.user.aggregate.valueobject;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirthDate {
    private LocalDateTime value;

    public Long getAge() {
        return ChronoUnit.YEARS.between(value, LocalDateTime.now());
    }

}
