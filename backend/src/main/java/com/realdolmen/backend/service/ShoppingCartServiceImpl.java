package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.ShoppingCart;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart findByUserId(Long userId) {
        return shoppingCartRepository.findByUserId(userId);
    }

    @Override
    public <S extends ShoppingCart> S save(S entity) {
        return shoppingCartRepository.save(entity);
    }

    @Override
    public ShoppingCart findById(Long aLong) {
        return shoppingCartRepository.findById(aLong).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public void delete(ShoppingCart entity) {

    }
}
