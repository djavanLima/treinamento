package com.github.djavanlima.Systask.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.github.djavanlima.Systask.api.controller.dto.TaskListDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "list", cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Item> items = new ArrayList();


    public void chageState(TaskList taskList) {
        this.setName(taskList.getName());
    }

    public TaskListDTO fromDomain() {
        var itemsDTO = getItems().stream().map(item-> item.fromDomain()).collect(Collectors.toList());
        return new TaskListDTO(
            getId(),
            getName(),
            itemsDTO
        );
    }
}
