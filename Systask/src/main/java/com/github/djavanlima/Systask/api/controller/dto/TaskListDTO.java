package com.github.djavanlima.Systask.api.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.github.djavanlima.Systask.model.TaskList;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskListDTO {
 
    private Long id;

    @Size(min = 2, max = 30, message = "Nome deve conter entre 2 e 30 caracteres")
    private String name;

    private List<ItemDTO> itemsDTO;

    public TaskList toDomain() {
        var items = getItemsDTO() != null ? itemsDTO.stream().map(itemDTO -> itemDTO.toDomain()).collect(Collectors.toList()) : new ArrayList();
        return new TaskList(
            getId(),
            getName(),
            items
        );
    }
}
