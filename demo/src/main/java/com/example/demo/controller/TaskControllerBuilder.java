package com.example.demo.controller;

import com.example.demo.repository.TaskRepository;

public class TaskControllerBuilder {
    private TaskRepository taskRepository;

    public TaskControllerBuilder setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        return this;
    }

    public TaskController createTaskController() {
        return new TaskController(taskRepository);
    }
}