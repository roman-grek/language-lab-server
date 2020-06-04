package com.languageschool.project.controller;

import com.languageschool.project.error.CourseNotFoundException;
import com.languageschool.project.error.GroupNotFoundException;
import com.languageschool.project.model.Course;
import com.languageschool.project.model.Group;
import com.languageschool.project.model.User;
import com.languageschool.project.payload.request.CreateGroupRequest;
import com.languageschool.project.payload.response.MessageResponse;
import com.languageschool.project.repository.CourseRepository;
import com.languageschool.project.repository.GroupRepository;
import com.languageschool.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/groups")
    Group newGroup(@RequestBody CreateGroupRequest groupRequest)
    {
        Course course = courseRepository.findByName(groupRequest.getCourseName())
                .orElseThrow(() -> new CourseNotFoundException(1L));
        User teacher = userRepository.findByUsername(groupRequest.getTeacherName())
                .orElseThrow(() -> new UsernameNotFoundException(groupRequest.getTeacherName()));
        Group newGroup = new Group(course, teacher);
        return groupRepository.save(newGroup);
    }

    @GetMapping("/groups/{id}")
    Group findOne(@PathVariable Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
    }

    @GetMapping("/user/{id}")
    Group groupByUserId(@PathVariable Long id) {
        User user = userRepository.findById(id)
		.orElseThrow(() -> new UsernameNotFoundException("teacher"));
        for (Group group: groupRepository.findAll()) {
            if (group.getStudents().contains(user)) {
                return group;
            }
        }
        throw new GroupNotFoundException(id);
    }

    @GetMapping("/teacher/{id}")
    List<Group> teacherGroups(@PathVariable Long id) {
        User teacher = userRepository.findById(id)
		.orElseThrow(() -> new UsernameNotFoundException("teacher"));
        return groupRepository.findByTeacher(teacher);
    }

    @PutMapping("/leave")
    ResponseEntity<?> leaveGroup(@RequestBody User user) {
        for (Group group: groupRepository.findAll()) {
            Set<User> students = group.getStudents();
            if (students.contains(user)) {
                students.remove(user);
                group.setStudents(students);
                return ResponseEntity.ok(new MessageResponse("Вы покинули группу"));
            }
        }
        throw new GroupNotFoundException(user.getId());
    }

    @DeleteMapping("/{id}")
    void deleteGroup(@PathVariable Long id) {
        groupRepository.deleteById(id);
    }
}
