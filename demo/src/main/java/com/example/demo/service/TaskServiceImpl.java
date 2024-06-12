package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task createTask(Task task, User user) {
        task.setUser(user);
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setDate(updatedTask.getDate());
            task.setDescription(updatedTask.getDescription());
            task.setDone(updatedTask.isDone());
            return taskRepository.save(task);
        });
    }

    @Override
    public void deleteTaskById(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }

    @Override
    public void markTaskAsDone(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.markAsDone(id);
        } else {
            throw new IllegalArgumentException("Task not found");
        }
    }

    @Override
    public Iterable<Task> getTasksByUser(User currentUser) {
        return taskRepository.findTasksByUser(currentUser);
    }
}
