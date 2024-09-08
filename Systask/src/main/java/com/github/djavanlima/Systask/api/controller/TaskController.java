package com.github.djavanlima.Systask.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.djavanlima.Systask.api.controller.dto.TaskListDTO;
import com.github.djavanlima.Systask.model.TaskList;
import com.github.djavanlima.Systask.service.ITaskListService;

@RestController
@RequestMapping("/task-list")
public class TaskController {
    @Autowired
    private ITaskListService taskListService;

    @GetMapping
    public List<TaskList> getAllLists() {
        return taskListService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskList> getListById(@PathVariable Long id) {
        TaskList taskList = taskListService.getTaskListById(id);
        return ResponseEntity.ok(taskList);
    }

    @PostMapping
    public TaskList create(@RequestBody TaskList list) {
        return taskListService.create(list);
    }

    @PutMapping("/{id}")
    public TaskList update(@PathVariable Long id, @RequestBody TaskList list) {
        return taskListService.update(id, list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskList(@PathVariable Long id) {
        taskListService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TaskListDTO>> filterItems(
            @RequestParam(required = false) String name
    ) {
        var taskListDTO = taskListService.findByName(name).stream()
                            .map(taskList -> taskList.fromDomain())
                            .collect(Collectors.toList());
                       
        return ResponseEntity.ok().body(taskListDTO);
    }
}
