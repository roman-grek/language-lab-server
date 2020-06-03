package com.languageschool.project.error;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(Long id) {
        super("Group id not found : " + id);
    }
}
