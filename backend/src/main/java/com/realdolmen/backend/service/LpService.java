package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.repository.LpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LpService {

    @Autowired
    private LpRepository lpRepository;

    public Lp create(Lp lp) {
        return lpRepository.saveAndFlush(lp);
    }

    public void delete(Lp lp) {
        lpRepository.delete(lp);
    }

    public Optional<Lp> findById(Long id) {
        return lpRepository.findById(id);
    }

    public List<Lp> findAll() {
        return lpRepository.findAll();
    }
}
