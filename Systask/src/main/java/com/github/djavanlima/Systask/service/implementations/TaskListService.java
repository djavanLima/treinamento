package com.github.djavanlima.Systask.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.djavanlima.Systask.model.TaskList;
import com.github.djavanlima.Systask.repository.TaskListRepository;
import com.github.djavanlima.Systask.service.ITaskListService;
import com.github.djavanlima.Systask.service.exceptions.TaskListNotFoundException;

@Service
public class TaskListService implements ITaskListService {

    @Autowired
    private TaskListRepository taskListRepository;

    @Override
    public TaskList getTaskListById(Long taskListId) {
        return taskListRepository.findById(taskListId).orElseThrow(TaskListNotFoundException::new);
    }

    @Override
    public TaskList create(TaskList taskList) {
        return taskListRepository.save(taskList);
    }

    @Override
    public TaskList update(Long id, TaskList taskList) {
        var taskListFromDataBase = getTaskListById(id);
        taskListFromDataBase.chageState(taskList);
        
        return taskListRepository.save(taskListFromDataBase);
    }

    @Override
    public void deleteById(Long id) {
        var taskList = getTaskListById(id);
        taskListRepository.delete(taskList);
    }

    @Override
    public List<TaskList> findAll() {
        return taskListRepository.findAll();
    }

    @Override
    public List<TaskList> findByName(String name) {
        return taskListRepository.findByName(name);
    }
}
