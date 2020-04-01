package com.languageschool.project.controller;

import com.languageschool.project.model.Course;
import com.languageschool.project.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.languageschool.project.error.CourseNotFoundException;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    // find
    @GetMapping("/courses")
    List<Course> findAll() {
        return (List<Course>) repository.findAll();
    }

    // save
    // return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/courses")
    Course newCourse(@RequestBody Course newCourse)
    {
        return repository.save(newCourse);
    }

    // find
    @GetMapping("/courses/{id}")
    Course findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    // save or update
    @PutMapping("/courses/{id}")
    Course saveOrUpdate(@PathVariable Long id, @RequestBody Course newCourse) {
        return repository.findById(id)
                .map(x -> {
                    x.setName(newCourse.getName());
                    x.setLanguage(newCourse.getLanguage());
                    x.setLevel(newCourse.getLevel());
                    x.setPrice(newCourse.getPrice());
                    x.setClassesCount(newCourse.getClassesCount());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newCourse.setId(id);
                    return repository.save(newCourse);
                });
    }

    @DeleteMapping("/courses/{id}")
    void deleteCourse(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
