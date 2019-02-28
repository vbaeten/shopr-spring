package com.realdolmen.backend.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArticleTest {

    private Article article;

    @Before
    public void Setup() {
        article = new Article();
    }

    @Test
    public void getId() {
        Long id = 2L;
        article.setId(id);
        assertEquals(id, article.getId());
    }

    @Test
    public void getTitle() {
        article.setTitle("Some Title");
        assertEquals("Some Title", article.getTitle());
    }

    @Test
    public void getPrice() {
        article.setPrice(20);
        assertEquals(20, article.getPrice(), 0.01 );
    }

    @Test
    public void getSupplier() {
        article.setSupplier("Dreamland");
        assertEquals("Dreamland", article.getSupplier());
    }

    @Test
    public void getType() {
        article.setType("FICTION");
        assertEquals("FICTION", article.getType());
    }
}
