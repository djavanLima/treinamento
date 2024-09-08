package com.github.djavanlima.Systask.service.builder;

import com.github.djavanlima.Systask.model.Item;
import com.github.djavanlima.Systask.model.TaskList;

public class ItemBuilder {
    Item item;

    public Item itemBuild() {
        return this.item;
    }

    public static ItemBuilder oneItem() {
        ItemBuilder itemBuilder = new ItemBuilder();

        itemBuilder.item = new Item(
            null,
            "Correr",
            "todos os dias correr pela manhã",
            Boolean.TRUE,
            Boolean.FALSE,
            new TaskList()
        );

        return itemBuilder;
    }

    public static ItemBuilder otherItem() {
        ItemBuilder itemBuilder = new ItemBuilder();

        itemBuilder.item = new Item(
            null,
            "Estudar",
            "todos os dias estudar pela manhã",
            Boolean.TRUE,
            Boolean.FALSE,
            new TaskList()
        );

        return itemBuilder;
    }

    public ItemBuilder withId() {
		this.item.setId(1L);
		return this;
	}

    public ItemBuilder withOtherId() {
		this.item.setId(2L);
		return this;
	}
}