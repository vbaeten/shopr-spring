package com.realdolmen.backend.service;

import java.util.List;

public interface CrudService<E, I> {

    E save(E entity);

    E findById(I primaryKey);

    List<E> findAll();

    void delete(E entity);

}
