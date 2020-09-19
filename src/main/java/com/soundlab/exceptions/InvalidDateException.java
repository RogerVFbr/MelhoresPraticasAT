package com.soundlab.exceptions;

import java.time.LocalDate;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(LocalDate date) {
        super(String.format("Date time '%s' is invalid for this operation.", date.toString()));
    };
}
