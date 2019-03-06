package com.realdolmen.backend.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testEqualsAndHashCode() {
        Article article1 = new Article();
        Article article2 = article1;
        assertEquals(article1, article2);
        assertTrue(article1.hashCode()==article2.hashCode());
    }

    @Test
    public void doesntEquals() throws Exception {
        Article article1 = new Article();
        Article article2 = new Article();
        article1.setId(5L);
        assertNotEquals(article1, article2);
    }

}
