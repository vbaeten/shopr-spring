package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.repository.FictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FictionService {

    @Autowired
    private FictionRepository fictionRepository;

    public Fiction create(Fiction fiction) {
        return fictionRepository.saveAndFlush(fiction);
    }

    public void delte(Fiction fiction) {
        fictionRepository.delete(fiction);
    }

    public Optional<Fiction> findById(Long id) {
        return fictionRepository.findById(id);
    }

    public List<Fiction> findAll() {
        return fictionRepository.findAll();
    }
}
