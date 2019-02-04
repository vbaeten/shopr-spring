package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.repository.LpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpServiceImpl implements LpService {

    private final LpRepository lpRepository;

    public LpServiceImpl(LpRepository lpRepository) {
        this.lpRepository = lpRepository;
    }

    @Override
    public <S extends Lp> S save(S entity) {
        return null;
    }

    @Override
    public Lp create(Lp lp) {
        return null;
    }

    @Override
    public Lp findById(Long id) {
        return null;
    }

    @Override
    public List<Lp> findAll() {
        return lpRepository.findAll();
    }

    @Override
    public void delete(Lp entity) {

    }
}
