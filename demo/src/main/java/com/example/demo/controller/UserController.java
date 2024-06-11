package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/me/tasks")
    public List<Task> getCurrentUserTasks() {
        User currentUser = userService.getCurrentUser();
        return taskRepository.findTasksByUser(currentUser);
    }
}
