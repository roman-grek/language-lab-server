package com.languageschool.project.repository;

import com.languageschool.project.model.Course;
import com.languageschool.project.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByCourse(Course course);
}
