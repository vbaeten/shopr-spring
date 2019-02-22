package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.Bookfiction;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.BookfictionRepository;
import com.realdolmen.backend.service.BookfictionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookfictionServiceImpl implements BookfictionService {

    private final BookfictionRepository bookfictionRepository;

    public BookfictionServiceImpl(BookfictionRepository bookfictionRepository) {
        this.bookfictionRepository = bookfictionRepository;
    }

    @Override
    public Bookfiction create(Bookfiction bookfiction) {
        return bookfictionRepository.save(bookfiction);
    }

    @Override
    public Bookfiction findById(Long articleId) {
        return bookfictionRepository.findById(articleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public <S extends Bookfiction> S save(S entity) {
        return bookfictionRepository.save(entity);
    }

    @Override
    public List<Bookfiction> findAll() {
        return bookfictionRepository.findAll();
    }

}
