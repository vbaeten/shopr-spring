package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Bookfiction;

public interface BookfictionService extends CrudService<Bookfiction, Long> {

    Bookfiction create(Bookfiction bookfiction);

    Bookfiction findById(Long articleId);
}
