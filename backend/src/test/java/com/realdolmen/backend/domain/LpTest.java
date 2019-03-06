package com.realdolmen.backend.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LpTest {

    private Lp lp;

    @Test
    public void testEqualsAndHashCode() {
        Lp lp1 = new Lp();
        Lp lp2 = lp1;
        assertEquals(lp1, lp2);
        assertTrue(lp1.hashCode()==lp2.hashCode());
    }

    @Test
    public void doesntEquals() throws Exception {
        Lp lp1 = new Lp();
        Lp lp2 = new Lp();
        lp1.setId(5L);
        assertNotEquals(lp1, lp2);
    }
}
