package com.github.djavanlima.Systask.service;

import java.util.List;

import com.github.djavanlima.Systask.model.TaskList;

public interface ITaskListService {

    List<TaskList> findAll(); 

    TaskList create(TaskList taskList);

    TaskList update(Long id, TaskList taskList);

    TaskList getTaskListById(Long taskListId);

    void deleteById(Long id);

    List<TaskList> findByName(String name);
}
