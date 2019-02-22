package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Booknonfiction;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.BooknonfictionRepository;
import com.realdolmen.backend.service.BooknonfictionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooknonfictionServiceImpl implements BooknonfictionService {

    private final BooknonfictionRepository booknonfictionRepository;

    public BooknonfictionServiceImpl(BooknonfictionRepository booknonfictionRepository) {
        this.booknonfictionRepository = booknonfictionRepository;
    }

    @Override
    public Booknonfiction create(Booknonfiction booknonfiction) {
        return booknonfictionRepository.save(booknonfiction);
    }

    @Override
    public Booknonfiction findById(Long articleId) {
        return booknonfictionRepository.findById(articleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public <S extends Booknonfiction> S save(S entity) {
        return booknonfictionRepository.save(entity);
    }

    @Override
    public List<Booknonfiction> findAll() {
        return booknonfictionRepository.findAll();
    }

}
