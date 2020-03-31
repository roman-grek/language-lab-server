package com.languageschool.project.error;

import java.util.Set;

public class CourseUnSupportedFieldPatchException extends RuntimeException {

    public CourseUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allowed.");
    }
}
