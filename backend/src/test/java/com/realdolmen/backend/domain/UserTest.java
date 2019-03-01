package com.realdolmen.backend.domain;

import com.realdolmen.backend.data.UserTestDataBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;

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

    @Test
    public void getRatings() {
        List<Rating> ratings = new ArrayList<>();
        Rating rating1 = new Rating();
        Rating rating2 = new Rating();
        ratings.add(rating1);
        ratings.add(rating2);
        User user = UserTestDataBuilder.buildUserBernadetteSanz().build();
        user.setRatings(ratings);

        assertEquals(user.getRatings().size(), ratings.size());
    }
}
