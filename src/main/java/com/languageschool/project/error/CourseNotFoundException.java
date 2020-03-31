package com.languageschool.project.error;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super("Course id not found : " + id);
    }
}
