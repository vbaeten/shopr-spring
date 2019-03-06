package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.FavoArticle;
import com.realdolmen.backend.domain.User;

import java.util.List;

public interface FavoArticleService extends CrudService<FavoArticle, Long> {
    List<FavoArticle> findFavosByUser(User user);

    void deleteById(Long id);
}
