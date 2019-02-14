package com.realdolmen.shoprbackend.services;

import com.realdolmen.shoprbackend.domain.Item;
import com.realdolmen.shoprbackend.exception.NotFoundException;
import com.realdolmen.shoprbackend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements CrudService<Item,Long> {


    private ItemRepository itemRepository;

    @Override
    public <S extends Item> S save(S entity) {
        return null;
    }

    @Override
    public Item findById(Long primaryKey) {
        return this.itemRepository.findById(primaryKey).
        orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public void delete(Item entity) {

    }


    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
}
