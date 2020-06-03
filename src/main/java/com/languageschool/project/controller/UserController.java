package com.languageschool.project.controller;

import com.languageschool.project.error.CourseNotFoundException;
import com.languageschool.project.model.Course;
import com.languageschool.project.model.Group;
import com.languageschool.project.model.User;
import com.languageschool.project.payload.response.MessageResponse;
import com.languageschool.project.repository.CourseRepository;
import com.languageschool.project.repository.UserRepository;
import com.languageschool.project.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/all")
    public String publicContent() {
        return "Добро пожаловать на сайт школы LanguageLab. Чтобы записаться на курс, войдите в аккаунт.";
    }

    @GetMapping("/users")
    List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping("/join/{id}")
    ResponseEntity<?> joinCourse(@PathVariable Long id, @RequestBody User user) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        for (Group group: groupRepository.findByCourse(course)) {
            Set<User> students = group.getStudents();
            if (students.size() < 12) {
                students.add(user);
                group.setStudents(students);
                return ResponseEntity.ok(new MessageResponse("Успешная запись на курс"));
            }
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Нет доступных групп для записи!"));

    }

    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
