package com.github.djavanlima.Systask.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.djavanlima.Systask.model.Item;
import com.github.djavanlima.Systask.repository.ItemRepository;
import com.github.djavanlima.Systask.service.IItemService;
import com.github.djavanlima.Systask.service.exceptions.ItemNotFoundException;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> findAll() {
       return itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public Item create(Item item) {
      return  itemRepository.save(item);
    }

    @Override
    public Item update(Long id,Item item) {
        var itemFromDataBase = findById(id);
        itemFromDataBase.chageState(item);

        return itemRepository.save(itemFromDataBase);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getItemsByTaskListId(Long taskListId) {
        return itemRepository.findItemsByTaskListId(taskListId);
    }

    @Override
    public List<Item> filterItems(String name, Boolean priority, Boolean completed) {
        return itemRepository.findItemsByfilter(name, priority, completed);
    }
}
