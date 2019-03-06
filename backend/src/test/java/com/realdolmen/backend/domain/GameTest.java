package com.realdolmen.backend.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Book book;

    @Test
    public void testEqualsAndHashCode() {
        Book book1 = new Book();
        Book book2 = book1;
        assertEquals(book1, book2);
        assertTrue(book1.hashCode()==book2.hashCode());
    }

    @Test
    public void doesntEquals() throws Exception {
        Book book1 = new Book();
        Book book2 = new Book();
        book1.setId(5L);
        assertNotEquals(book1, book2);
    }
}
