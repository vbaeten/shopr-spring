package com.realdolmen.backend.service;

import java.util.List;

public interface CrudService<T, K> {

    <S extends T> S save(S entity);

    T findById(K primaryKey);

    List<T> findAll();

}
