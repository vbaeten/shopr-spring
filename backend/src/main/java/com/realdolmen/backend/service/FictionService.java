package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.FictionBook;

public interface FictionService extends CrudService<FictionBook, Long> {

    FictionBook create(FictionBook fictionBook);

    FictionBook findById(Long id);

}
