package com.realdolmen.backend.service;

import com.realdolmen.backend.data.UserTestDataBuilder;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.exception.NotFoundException;
import com.realdolmen.backend.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNull;
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
        User expectedUser = UserTestDataBuilder.buildUserBernadetteSanz().build();
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedUser));
        User foundUser = this.userServiceImpl.findById(1L);

        verify(userRepository, times(1)).findById(1L);
        assertEquals(expectedUser.getFirstName(), foundUser.getFirstName());
        assertEquals(expectedUser.getId(), foundUser.getId());
    }

    @Test
    public void testSaveProfile() {
        User expectedUser = UserTestDataBuilder.buildUserBernadetteSanz().build();

        when(userRepository.save(any())).thenReturn(expectedUser);

        User savedUser = this.userServiceImpl.save(expectedUser);

        verify(userRepository, times(1)).save(expectedUser);
        assertEquals(expectedUser, savedUser);
    }


    @Test
    public void findAll() {
        List<User> expectedUsers = new ArrayList<>();
        User user1 = UserTestDataBuilder.buildUserBernadetteSanz().build();
        User user2 = UserTestDataBuilder.buildUserJuttaRoggen().build();
        expectedUsers.add(user1);
        expectedUsers.add(user2);

        when(userRepository.findAll()).thenReturn(expectedUsers);

        List<User> foundUsers = this.userServiceImpl.findAll();

        verify(userRepository, times(1)).findAll();
        assertEquals(expectedUsers.size(), foundUsers.size());
    }

    @Test
    public void delete() {
        User user = UserTestDataBuilder.buildUserBernadetteSanz().build();
        userServiceImpl.delete(user);

        verify(userRepository, times(1)).delete(user);
    }

    @Test(expected = NotFoundException.class)
    public void findByIdUserNotFound() {
        User notFound = userServiceImpl.findById(1L);

        when(userRepository.findById(any())).thenReturn(Optional.of(notFound));

        verify(userRepository, times(1)).findById(any());
        assertNull(userServiceImpl.findById(any()));
    }

    @Test
    public void deleteById() throws NotFoundException {
        User expectedUser = UserTestDataBuilder.buildUserBernadetteSanz().build();
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(expectedUser));

        userServiceImpl.deleteById(1L);

        verify(userRepository, times(1)).findById(1L) ;
        verify(userRepository, times(1)).delete(expectedUser);
    }
}




