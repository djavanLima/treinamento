package com.github.djavanlima.Systask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.djavanlima.Systask.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
  
   @Query(value= "select i from TaskList t join t.items i where t.id = :taskListId ")
   List<Item> findItemsByTaskListId(@Param(":taskListId") Long taskListId);

   @Query("SELECT i FROM Item i WHERE " +
   "(:name IS NULL OR i.name LIKE %:name%) AND " +
   "(:priority IS NULL OR i.priority = :priority) AND " +
   "(:completed IS NULL OR i.completed = :completed)")
    List<Item> findItemsByfilter(@Param("name") String name,
                            @Param("priority") Boolean priority,
                            @Param("completed") Boolean completed);

}
