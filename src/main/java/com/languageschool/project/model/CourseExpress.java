package com.languageschool.project.model;

public class CourseExpress extends Course {

    public CourseExpress(String name, String level, String language, Integer price) {
        super(name, level, language, price, 3);
    }

    public void setClassesCount() {
        setClassesCount(3);
    }
}
