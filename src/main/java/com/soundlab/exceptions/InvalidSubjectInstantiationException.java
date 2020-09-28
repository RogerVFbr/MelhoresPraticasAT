package com.soundlab.exceptions;

public class InvalidSubjectInstantiationException extends RuntimeException{
    public InvalidSubjectInstantiationException() {
        super("Unable to instantiate.");
    }
}
