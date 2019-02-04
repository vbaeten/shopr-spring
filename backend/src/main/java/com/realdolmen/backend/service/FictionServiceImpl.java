package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.FictionBook;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.FictionBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FictionServiceImpl implements FictionService {

    private final FictionBookRepository fictionBookRepository;

    public FictionServiceImpl(FictionBookRepository fictionBookRepository) {
        this.fictionBookRepository = fictionBookRepository;
    }

    @Override
    public <S extends FictionBook> S save(S entity) {
        return null;
    }

    @Override
    public FictionBook create(FictionBook fictionBook) {
        return null;
    }

    @Override
    public FictionBook findById(Long id) {
        return fictionBookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<FictionBook> findAll() {
        return fictionBookRepository.findAll();
    }

    @Override
    public void delete(FictionBook entity) {

    }
}
