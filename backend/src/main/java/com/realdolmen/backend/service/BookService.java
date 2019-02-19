package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Book;

import java.util.List;

public interface BookService extends CrudService<Book,Long>{

    List<Book> findAll();


}
