package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFiction;

public interface NonFictionService extends CrudService<NonFiction, Long> {

    NonFiction create(NonFiction nonFiction);

    NonFiction findById(Long id);

}
