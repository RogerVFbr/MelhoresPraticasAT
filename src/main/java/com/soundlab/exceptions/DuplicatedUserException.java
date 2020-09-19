package com.soundlab.exceptions;

import com.soundlab.core.user.aggregate.entity.User;

public class DuplicatedUserException extends RuntimeException{

    public DuplicatedUserException(User user) {
        super(String.format("User '%s' (%s) is already present on this list.", user.getName(),
            user.getId().toString()));
    }
}
