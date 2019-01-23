package com.realdolmen.shoprbackend.services;

import java.util.List;

public interface CrudService<T,ID> {

    <S extends T> S save (S entity);

    T findById(ID primaryKey);

    List<T> findAll();

    void delete ( T entity);

}
