package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.repository.LpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LpService {

    @Autowired
    private LpRepository lpRepository;

    public Lp save(Lp lp) {
        return lpRepository.saveAndFlush(lp);
    }

    public void delete(Lp lp) {
        lpRepository.delete(lp);
    }

    public Lp findById(Long id) {
        return lpRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Lp> findAll() {
        return lpRepository.findAll();
    }
}
