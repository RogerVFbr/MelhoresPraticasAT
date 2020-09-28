package com.soundlab.core.user.aggregate.valueobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirthDate {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate value;

    public Long getAge() {
        return ChronoUnit.YEARS.between(value, LocalDateTime.now());
    }

    @JsonIgnore
    public LocalDate getValue() {
        return value;
    }

}
