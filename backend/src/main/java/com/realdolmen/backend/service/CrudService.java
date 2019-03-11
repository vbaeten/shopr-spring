package com.realdolmen.backend.service;

import com.realdolmen.backend.exceptions.NotFoundException;

import java.util.List;

public interface CrudService<E, I> {

    E save(E entity);

    E findById(I primaryKey) throws NotFoundException;

    List<E> findAll();

    void delete(E entity);

}
