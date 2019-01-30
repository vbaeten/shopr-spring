package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Fiction;
import com.realdolmen.backend.repository.FictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FictionService {

    @Autowired
    private FictionRepository fictionRepository;

    public Fiction save(Fiction fiction) {
        return fictionRepository.saveAndFlush(fiction);
    }

    public void delete(Fiction fiction) {
        fictionRepository.delete(fiction);
    }

    public Fiction findById(Long id) {
        return fictionRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Fiction> findAll() {
        return fictionRepository.findAll();
    }
}
