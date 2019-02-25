package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Fiction;

public interface FictionService extends CrudService<Fiction, Long> {

    Fiction create(Fiction fiction);

    Fiction findById(Long id);

}
