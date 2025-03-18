package com.exiti.taskmanager.service;

import com.exiti.taskmanager.models.Task;
import com.exiti.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task newTask) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    task.setCompleted(newTask.isCompleted());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
