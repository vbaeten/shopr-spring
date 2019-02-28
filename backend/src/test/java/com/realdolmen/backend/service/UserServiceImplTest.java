package com.realdolmen.backend.service;

import com.realdolmen.backend.data.UserTestDataBuilder;
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
import static org.mockito.Mockito.*;


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
    public void userCanByFoundById() {
        User user = UserTestDataBuilder.buildUserBernadetteSanz().build();
        assertEquals("Bernadette", user.getFirstName());
    }

    @Test
    public void testSaveProfile() {
        User expectedUser = UserTestDataBuilder.buildUserBernadetteSanz().build();

        when(userRepository.save(any())).thenReturn(expectedUser);

        User savedUser = this.userServiceImpl.create(expectedUser);

        verify(userRepository, times(1)).save(expectedUser);
        assertEquals(expectedUser, savedUser);
    }
}




