package com.github.djavanlima.Systask.service;

import java.util.List;
import java.util.Optional;

import com.github.djavanlima.Systask.model.Item;

public interface IItemService {
    
    List<Item> findAll();

	Item findById(Long id);

	Item create(Item item);

	Item update(Long id, Item cliente);
	
	void delete(Long id);

    List<Item> getItemsByTaskListId(Long taskListId);

    List<Item> filterItems(String name, Boolean priority, Boolean completed);
}
