package com.soundlab.exceptions;

public class TooManyContactsException extends RuntimeException {

    public TooManyContactsException() {
        super("Maximum number of contacts exceeded (2).");
    }
}
