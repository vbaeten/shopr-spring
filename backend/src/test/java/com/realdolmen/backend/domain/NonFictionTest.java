package com.realdolmen.backend.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonFictionTest {

    private NonFiction nonFiction;

    @Test
    public void testEqualsAndHashCode() {
        NonFiction nonFiction1 = new NonFiction();
        NonFiction nonFiction2 = nonFiction1;
        assertEquals(nonFiction1, nonFiction2);
        assertTrue(nonFiction1.hashCode()==nonFiction2.hashCode());
    }

    @Test
    public void doesntEquals() throws Exception {
        NonFiction nonFiction1 = new NonFiction();
        NonFiction nonFiction2 = new NonFiction();
        nonFiction1.setId(5L);
        assertNotEquals(nonFiction1, nonFiction2);
    }
}
