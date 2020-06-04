package com.languageschool.project.payload.request;

import javax.validation.constraints.*;

public class CreateGroupRequest {
    @NotBlank
    private String teacherName;

    @NotBlank
    private String courseName;


    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
