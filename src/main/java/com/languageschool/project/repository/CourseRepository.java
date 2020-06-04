package com.languageschool.project.repository;

import com.languageschool.project.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    @Override
    List<Course> findAll();

}
