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
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userServiceImpl;



    private User user;

    @Test
    public void shouldMockFacade() {
        assertNotNull(userServiceImpl);
    }
    @Before
    public void init() {
    }

    @Test
    public void userCanByFoundById() throws Exception {
        User user2 = userServiceImpl.findById(1L);
        assertEquals(1L, user.getId().longValue());
    }
}




