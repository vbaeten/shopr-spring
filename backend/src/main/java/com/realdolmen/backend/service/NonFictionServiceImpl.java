package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.NonFictionBook;
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
    public <S extends NonFictionBook> S save(S entity) {
        return nonFictionBookRepository.save(entity);
    }

    @Override
    public NonFictionBook create(NonFictionBook nonFictionBook) {
        return nonFictionBookRepository.save(nonFictionBook);
    }

    @Override
    public NonFictionBook findById(Long id) {
        return nonFictionBookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<NonFictionBook> findAll() {
        return nonFictionBookRepository.findAll();
    }

    @Override
    public void delete(NonFictionBook nonFictionBook) {
        nonFictionBookRepository.delete(nonFictionBook);
    }
}
