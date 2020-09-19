package com.soundlab.exceptions;

public class DatabaseEntryInexistentException extends RuntimeException{

    public DatabaseEntryInexistentException() {
        super("Entry doesn't exists on repository.");
    }
}
