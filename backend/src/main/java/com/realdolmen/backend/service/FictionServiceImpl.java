package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Fiction;
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
    public <S extends Fiction> S save(S entity) {
        return fictionBookRepository.save(entity);
    }


    @Override
    public Fiction findById(Long id) {
        return fictionBookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Fiction> findAll() {
        return fictionBookRepository.findAll();
    }

    @Override
    public void delete(Fiction entity) {
        fictionBookRepository.delete(entity);
    }
}
