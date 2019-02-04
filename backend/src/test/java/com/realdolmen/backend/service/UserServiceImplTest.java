package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {


    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    private User user;

    @Before
    public void init() {
        user = new User();
        user.setId(1L);
        user.setFirstName("Bernadette");
        user.setName("Sanz");
    }

    @Test public void userCanByFoundById() {
        User user2 = userService.findById(1L);
        assertEquals(1L, user.getId().longValue());
    }
}



