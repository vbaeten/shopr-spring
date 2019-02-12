package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.exceptions.NotFoundException;
import com.realdolmen.backend.repository.NonFictionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NonFictionServiceImpl implements NonFictionService {

    private NonFictionRepository nonFictionRepository;

    @Override
    public NonFiction save(NonFiction nonFiction) {
        return nonFictionRepository.save(nonFiction);
    }

    @Override
    public NonFiction findById(Long id) {
        return nonFictionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<NonFiction> findAll() {
        return nonFictionRepository.findAll();
    }

    @Override
    public void delete(NonFiction nonFiction) {
        nonFictionRepository.delete(nonFiction);
    }
}
