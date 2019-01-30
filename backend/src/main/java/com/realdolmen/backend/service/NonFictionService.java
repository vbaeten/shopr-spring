package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.repository.NonFictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonFictionService {

    @Autowired
    private NonFictionRepository nonFictionRepository;

    public NonFiction save(NonFiction nonFiction) {
        return nonFictionRepository.saveAndFlush(nonFiction);
    }

    public void delete(NonFiction nonFiction) {
        nonFictionRepository.delete(nonFiction);
    }

    public NonFiction findById(Long id) {
        return nonFictionRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<NonFiction> findAll() {
        return nonFictionRepository.findAll();
    }
}
