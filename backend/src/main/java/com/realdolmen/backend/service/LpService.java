package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;

public interface LpService extends CrudService<Lp, Long> {

    Lp create(Lp lp);

    Lp findById(Long articleId);
}
