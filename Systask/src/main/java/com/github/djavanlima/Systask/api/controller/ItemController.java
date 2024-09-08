package com.github.djavanlima.Systask.api.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.djavanlima.Systask.api.controller.dto.ItemDTO;
import com.github.djavanlima.Systask.service.IItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private IItemService itemService;

        @Autowired
        private UriComponentsBuilder uriComponentsBuilder;

    @GetMapping
    public List<ItemDTO> findAll() {
        return itemService.findAll().stream().map(item -> item.fromDomain()).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> findItemById(@PathVariable Long id) {
        var itemDTO = itemService.findById(id).fromDomain();
        return ResponseEntity.ok(itemDTO);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {

        itemDTO = itemService.create(itemDTO.toDomain()).fromDomain();

        var uri = uriComponentsBuilder.path("/items")
				.buildAndExpand(itemDTO.getId().toString()).toUri();

        return ResponseEntity.created(uri).body(itemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasklist/{id}")
    public ResponseEntity<List<ItemDTO>> getItemsByListId(@PathVariable Long id) {
    var itemsDTO = itemService.getItemsByTaskListId(id).stream()
                    .map(item -> item.fromDomain())
                    .collect(Collectors.toList());

        return ResponseEntity.ok().body(itemsDTO);
    }

    @GetMapping("/filter")
    public List<ItemDTO> filterItems(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean priority,
            @RequestParam(required = false) Boolean completed
    ) {
        return itemService.filterItems(name, priority, completed).stream()
                .map(item -> item.fromDomain())
                .collect(Collectors.toList());
    }
}
