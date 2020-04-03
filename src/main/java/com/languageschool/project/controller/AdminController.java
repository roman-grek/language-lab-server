package com.languageschool.project.controller;

import com.languageschool.project.model.User;
import com.languageschool.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://language-lab-client.herokuapp.com")
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    List<User> userList() {
        return userService.allUsers();
    }

    @PostMapping("/admin")
    void deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
    }
}
