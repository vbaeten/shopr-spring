package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.repository.LpRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LpServiceImpl implements LpService {

    private LpRepository lpRepository;

    @Override
    public Lp save(Lp lp) {
        return lpRepository.save(lp);
    }

    @Override
    public Lp findById(Long id) throws NotFoundException {
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
