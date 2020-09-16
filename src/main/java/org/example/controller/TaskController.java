package org.example.controller;

import org.aspectj.bridge.Message;
import org.example.service.TaskService;
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
    public ResponseEntity<Message> create(@RequestBody String task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Message>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.listTasks());
    }

    @GetMapping(value= "{id}")
    public ResponseEntity<Message> findOne(@PathVariable("id") Integer taskId){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findTask(taskId));
    }

    @PutMapping(value= "{id}")
    public ResponseEntity<Message> update(@PathVariable("id") Integer taskId, @RequestBody String task){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(taskId, task));
    }

    @DeleteMapping
    public ResponseEntity<List> deleteAll(){
        taskService.deleteAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
