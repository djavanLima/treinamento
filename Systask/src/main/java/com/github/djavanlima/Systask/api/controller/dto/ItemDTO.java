package com.github.djavanlima.Systask.api.controller.dto;

import com.github.djavanlima.Systask.model.Item;
import com.github.djavanlima.Systask.model.TaskList;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private Long id;

    @Size(min = 2, max = 30, message = "Nome deve conter entre 2 e 30 caracteres")
    private String name;

    @Size(min = 0, max = 255, message = "Descrição deve conter no máximo 255 caracteres")
    private String description;

    private boolean priority;

    private boolean completed;

    private TaskList taskList;

    public Item toDomain() {
        return new Item(
            getId(),
            getName(),
            getDescription(),
            isPriority(),
            isCompleted(),
            getTaskList()
        );
    }
}
