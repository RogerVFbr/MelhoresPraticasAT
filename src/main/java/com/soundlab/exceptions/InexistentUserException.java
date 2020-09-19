package com.soundlab.exceptions;

import com.soundlab.core.user.aggregate.entity.User;

public class InexistentUserException extends RuntimeException{

    public InexistentUserException(User user) {
        super(String.format("User '%s' (%s) is not present on this list.", user.getName(),
            user.getId().toString()));
    }
}
