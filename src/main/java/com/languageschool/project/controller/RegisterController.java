package com.languageschool.project.controller;

import com.languageschool.project.error.UserAlreadyExistsException;
import com.languageschool.project.model.User;
import com.languageschool.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "https://language-lab-client.herokuapp.com")
@RequestMapping("/api/v1")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    void addUser(@RequestBody User newUser) {
        if(!userService.saveUser(newUser)) {
            throw new UserAlreadyExistsException(newUser.getUsername());
        }
    }

}
