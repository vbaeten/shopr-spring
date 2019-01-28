package com.realdolmen.shoprbackend.controller;


import com.realdolmen.shoprbackend.domain.Item;
import com.realdolmen.shoprbackend.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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



    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

}
