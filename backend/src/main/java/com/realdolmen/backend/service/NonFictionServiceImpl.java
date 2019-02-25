package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFiction;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.NonFictionBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonFictionServiceImpl implements NonFictionService {

    private final NonFictionBookRepository nonFictionBookRepository;

    public NonFictionServiceImpl(NonFictionBookRepository nonFictionBookRepository) {
        this.nonFictionBookRepository = nonFictionBookRepository;
    }

    @Override
    public <S extends NonFiction> S save(S entity) {
        return nonFictionBookRepository.save(entity);
    }

    @Override
    public NonFiction create(NonFiction nonFiction) {
        return nonFictionBookRepository.save(nonFiction);
    }

    @Override
    public NonFiction findById(Long id) {
        return nonFictionBookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<NonFiction> findAll() {
        return nonFictionBookRepository.findAll();
    }

    @Override
    public void delete(NonFiction nonFiction) {
        nonFictionBookRepository.delete(nonFiction);
    }
}
