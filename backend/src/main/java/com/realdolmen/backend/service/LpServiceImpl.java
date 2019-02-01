package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpServiceImpl implements LpService {

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
        return null;
    }

    @Override
    public void delete(Lp entity) {

    }
}
