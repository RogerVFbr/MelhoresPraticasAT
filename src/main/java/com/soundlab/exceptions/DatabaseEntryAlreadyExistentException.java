package com.soundlab.exceptions;

public class DatabaseEntryAlreadyExistentException extends RuntimeException{

    public DatabaseEntryAlreadyExistentException() {
        super("Entry already exists on repository.");
    }
}
