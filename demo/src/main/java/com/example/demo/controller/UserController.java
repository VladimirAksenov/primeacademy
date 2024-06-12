package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/me")
    public @ResponseBody User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
