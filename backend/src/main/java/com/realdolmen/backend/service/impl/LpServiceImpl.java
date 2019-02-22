package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.LpRepository;
import com.realdolmen.backend.service.LpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpServiceImpl implements LpService {

    private final LpRepository lpRepository;

    public LpServiceImpl(LpRepository lpRepository) {
        this.lpRepository = lpRepository;
    }

    @Override
    public Lp create(Lp lp) {
        return lpRepository.save(lp);
    }

    @Override
    public Lp findById(Long articleId) {
        return lpRepository.findById(articleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public <S extends Lp> S save(S entity) {
        return lpRepository.save(entity);
    }

    @Override
    public List<Lp> findAll() {
        return lpRepository.findAll();
    }
}
