package com.realdolmen.backend.service;

import java.util.List;

public interface CrudService<T, ID> {
    <S extends T> S save(S entity);

    T findById(ID id);

    List<T> findAll();

    void delete(T entity);

}
