package com.soundlab.exceptions;

public class InvalidGradeIndexException extends RuntimeException{

    public InvalidGradeIndexException(int index) {
        super(String.format("Index '%s' does not exist in list.", index));
    }
}
