package com.realdolmen.backend.service.impl;

import com.realdolmen.backend.domain.FavoArticle;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repositories.FavoArticleRepository;
import com.realdolmen.backend.service.FavoArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoArticleServiceImpl implements FavoArticleService {

    private final FavoArticleRepository favoArticleRepository;

    public FavoArticleServiceImpl(FavoArticleRepository favoArticleRepository) {
        this.favoArticleRepository = favoArticleRepository;
    }

    @Override
    public FavoArticle findById(Long favoArticleId) {
        return favoArticleRepository.findById(favoArticleId).orElseThrow(NotFoundException::new);
    }

    @Override
    public <S extends FavoArticle> S save(S entity) {
        return favoArticleRepository.save(entity);
    }

    @Override
    public List<FavoArticle> findAll() {
        return favoArticleRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        favoArticleRepository.deleteById(id);
    }

    @Override
    public List<FavoArticle> findFavosByUser(User user) {
        return favoArticleRepository.findByUser(user);
    }
}
