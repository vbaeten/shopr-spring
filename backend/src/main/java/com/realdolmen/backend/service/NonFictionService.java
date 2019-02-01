package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFictionBook;

public interface NonFictionService extends CrudService<NonFictionBook, Long> {

    NonFictionBook create(NonFictionBook nonFictionBook);

    NonFictionBook findById(Long id);

}
