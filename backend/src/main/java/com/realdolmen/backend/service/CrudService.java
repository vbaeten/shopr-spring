package com.realdolmen.backend.service;

import java.util.List;

public interface CrudService<E, ID> {

    E save(E entity);

    E findById(ID primaryKey);

    List<E> findAll();

    void delete(E entity);

}
