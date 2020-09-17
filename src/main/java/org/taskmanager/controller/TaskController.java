package org.taskmanager.controller;


import org.taskmanager.domain.Task;
import org.taskmanager.dto.TaskDTO;
import org.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody String task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.listTasks());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Task> findOne(@PathVariable("id") Integer taskId) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findTask(taskId));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Task> update(@PathVariable("id") Integer taskId, @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(taskId, taskDTO));
    }

    @DeleteMapping
    public ResponseEntity<List> deleteAll() {
        taskService.deleteAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
