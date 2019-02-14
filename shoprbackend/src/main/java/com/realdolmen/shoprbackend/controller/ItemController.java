package com.realdolmen.shoprbackend.controller;


import com.realdolmen.shoprbackend.domain.Item;
import com.realdolmen.shoprbackend.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/items")
public class ItemController {


    private ItemService itemService;


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> findAll(){
        return itemService.findAll();
    }


    @GetMapping("/{id}")
    public Item findById(@PathVariable Long id ){
        return this.itemService.findById(id);
    }

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

}
