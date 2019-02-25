package com.realdolmen.backend.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    User user;

    @Before
    public void SetUp(){
        user = new User();
    }

    @Test
    public void getId() {
        Long idValue = 4L;

        user.setId(idValue);

        assertEquals(idValue, user.getId());
    }

    @Test
    public void getName() {
        String name = "Roggen";

        user.setName(name);

        assertEquals(name, user.getName());
    }

    @Test
    public void getFirstName() {
        String firstName = "Jutta";

        user.setFirstName("Jutta");

        assertEquals(firstName, user.getFirstName());
    }
}
