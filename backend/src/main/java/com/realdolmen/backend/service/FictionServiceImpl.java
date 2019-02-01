package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.FictionBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FictionServiceImpl implements FictionService {

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
        return null;
    }

    @Override
    public List<FictionBook> findAll() {
        return null;
    }

    @Override
    public void delete(FictionBook entity) {

    }
}
