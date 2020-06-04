package com.languageschool.project.payload.request;

import javax.validation.constraints.*;

public class JoinGroupRequest {
    @NotBlank
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
