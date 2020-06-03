package com.languageschool.project.controller;

import com.languageschool.project.error.GroupNotFoundException;
import com.languageschool.project.model.Group;
import com.languageschool.project.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/groups")
    Group newGroup(@RequestBody Group newGroup)
    {
        return groupRepository.save(newGroup);
    }

    @GetMapping("/groups/{id}")
    Group findOne(@PathVariable Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id) {
        groupRepository.deleteById(id);
    }
}
