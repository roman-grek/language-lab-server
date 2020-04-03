package com.languageschool.project.error;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String userName) {
        super("User " + userName + " already registered");
    }
}
