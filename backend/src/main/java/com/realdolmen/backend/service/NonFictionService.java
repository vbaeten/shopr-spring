package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.repository.NonFictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NonFictionService {

    @Autowired
    private NonFictionRepository nonFictionRepository;

    public NonFiction create(NonFiction nonFiction) {
        return nonFictionRepository.saveAndFlush(nonFiction);
    }

    public void delete(NonFiction nonFiction) {
        nonFictionRepository.delete(nonFiction);
    }

    public Optional<NonFiction> findById(Long id) {
        return nonFictionRepository.findById(id);
    }

}