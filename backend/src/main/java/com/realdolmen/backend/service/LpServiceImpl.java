package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.exception.NotFoundException;
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
    public <S extends Lp> S save(S lp) {
        return lpRepository.save(lp);
    }

    @Override
    public Lp findById(Long id) {
        return lpRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Lp> findAll() {
        return lpRepository.findAll();
    }

    @Override
    public void delete(Lp lp) {
        lpRepository.delete(lp);
    }
}
