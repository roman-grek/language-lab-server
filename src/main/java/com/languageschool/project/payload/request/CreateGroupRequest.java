package com.languageschool.project.payload.request;

import javax.validation.constraints.*;

public class CreateGroupRequest {
    @NotBlank
    private Long teacherId;

    @NotBlank
    private Long courseId;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
