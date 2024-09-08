package com.github.djavanlima.Systask.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.djavanlima.Systask.model.Item;
import com.github.djavanlima.Systask.repository.ItemRepository;
import com.github.djavanlima.Systask.service.implementations.ItemService;

@SpringBootTest
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFilterItems() {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("correr");
        item1.setPriority(true);
        item1.setCompleted(false);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("andar");
        item2.setPriority(false);
        item2.setCompleted(true);

        when(itemRepository.findItemsByfilter("correr", true, false)).thenReturn(Arrays.asList(item1));

        List<Item> result = itemService.filterItems("correr", true, false);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("correr", result.get(0).getName());
        verify(itemRepository, times(1)).findItemsByfilter("correr", true, false);
    }
}
