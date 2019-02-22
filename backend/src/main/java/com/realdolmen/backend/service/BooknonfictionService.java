package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Booknonfiction;

public interface BooknonfictionService extends CrudService<Booknonfiction, Long> {

    Booknonfiction create(Booknonfiction booknonfiction);

    Booknonfiction findById(Long articleId);
}
