package com.brunogamedev.todo.controller;

import com.brunogamedev.todo.model.Task;
import com.brunogamedev.todo.request.ByIdRequest;
import com.brunogamedev.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }
    @PostMapping("/list-all")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }
    @PostMapping("/findById")
    public ResponseEntity<Task> getTaskById(@RequestBody ByIdRequest id) {
        return new ResponseEntity<>(taskService.getTaskById(id.getId()), HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteTask(@RequestBody ByIdRequest id) {
        taskService.deleteTask(id.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
