package com.languageschool.project.model;

public class CourseStandard extends Course {

    public CourseStandard(String name, String level, String language, Integer price) {
        super(name, level, language, price, 2);
    }

    public void setClassesCount() {
        setClassesCount(2);
    }
}
