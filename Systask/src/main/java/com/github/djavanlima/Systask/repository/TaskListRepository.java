package com.github.djavanlima.Systask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.djavanlima.Systask.model.TaskList;

public interface TaskListRepository extends JpaRepository<TaskList, Long>  {

    List<TaskList> findByName(String name);
    
}
