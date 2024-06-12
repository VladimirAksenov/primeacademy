package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;

import java.util.Optional;

public interface TaskService {

    Task createTask(Task task, User user);

    Iterable<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);

    Optional<Task> updateTask(Long id, Task updatedTask);

    void deleteTaskById(Long id);

    void markTaskAsDone(Long id);

    Iterable<Task> getTasksByUser(User user);

}
