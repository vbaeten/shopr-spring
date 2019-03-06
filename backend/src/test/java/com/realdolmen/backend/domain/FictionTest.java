package com.realdolmen.backend.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class FictionTest {

    private Book book;


    @Test
    public void testEqualsAndHashCode() {
        Fiction fiction1 = new Fiction();
        Fiction fiction2 = fiction1;
        assertEquals(fiction1, fiction2);
        assertTrue(fiction1.hashCode()==fiction2.hashCode());
    }

    @Test
    public void doesntEquals() throws Exception {
        Fiction fiction1 = new Fiction();
        Fiction fiction2 = new Fiction();
        fiction1.setId(5L);
        assertNotEquals(fiction1, fiction2);
    }
}
