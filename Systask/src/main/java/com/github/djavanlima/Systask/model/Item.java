package com.github.djavanlima.Systask.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.djavanlima.Systask.api.controller.dto.ItemDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean priority;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "list_id")
    @JsonIgnore
    private TaskList list;

    public void chageState(Item item) {
        this.setName(item.getName());
        this.setDescription(item.getDescription());
        this.setPriority(item.isPriority());
        this.setCompleted(item.isCompleted());
    }

    public ItemDTO fromDomain() {
        return new ItemDTO(getId(), getName(), getDescription(), isPriority(), isCompleted(), getList());
    }
}
