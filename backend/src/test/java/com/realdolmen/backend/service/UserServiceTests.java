package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserAmir;
import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserKarel;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;

    @Test
    public void testSaveAllArgsUser() {
        //Create test data
        User expectedUser = buildUserKarel().build();

        //Mocking of Repository
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);

        //Execute method to be tested
        User savedUser = this.userService.save(expectedUser);

        //Verifications & Assertions
        verify(userRepository, times(1)).save(expectedUser);

        assertEquals(expectedUser.getId(), savedUser.getId());
        assertEquals(expectedUser.getFirstName(), savedUser.getFirstName());
        assertEquals(expectedUser.getName(), savedUser.getName());

        assertThat(savedUser, allOf(
                hasProperty("id", equalTo(expectedUser.getId())),
                hasProperty("firstName", equalTo(expectedUser.getFirstName())),
                hasProperty("name", equalTo(expectedUser.getName()))
        ));
    }

    @Test
    public void testSaveCustomArgsUser() {
        //Create test data
        User expectedUser = new User("no", "id");

        //Mocking of Repository
        when(userRepository.save(any())).thenReturn(expectedUser);

        //Execute method to be tested
        User savedUser = this.userService.save(expectedUser);

        //Verifications & Assertions
        verify(userRepository, times(1)).save(expectedUser);

        assertEquals(expectedUser.getId(), savedUser.getId());
        System.out.println(expectedUser.getId());
        assertEquals(expectedUser.getFirstName(), savedUser.getFirstName());
        System.out.println(expectedUser.getFirstName());
        assertEquals(expectedUser.getName(), savedUser.getName());
        System.out.println(expectedUser.getName());
    }

    @Test
    public void testSettersUser() {
        //TODO: handle exception when no args are passed
        //Create test data
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setFirstName("Amir");
        expectedUser.setName("Malik");

        //Mocking of Repository
        when(userRepository.save(any())).thenReturn(expectedUser);

        //Execute method to be tested
        User savedUser = this.userService.save(expectedUser);

        //Verifications & Assertions
        verify(userRepository, times(1)).save(expectedUser);

        assertEquals(expectedUser.getId(), savedUser.getId());
        assertEquals(expectedUser.getFirstName(), savedUser.getFirstName());
        assertEquals(expectedUser.getName(), savedUser.getName());

    }

    @Test
    public void testFindById() {
        //Create test data
        User expectedUser = buildUserKarel().build();

        //Mocking of Repository
        when(userRepository.findById(expectedUser.getId())).thenReturn(Optional.of(expectedUser));

        //Perform action te be tested
        User foundUser = this.userService.findById(expectedUser.getId());

        //Verifications & Assertions
        verify(userRepository, times(1)).findById(expectedUser.getId());
        assertEquals(expectedUser, foundUser);

    }

    @Test
    public void testFindAll() {
        //Create test data
        List<User> expectedUsers = Arrays.asList(
                buildUserAmir().build(),
                buildUserKarel().build()
        );

        //Mocking of Repository
        when(userRepository.findAll()).thenReturn(expectedUsers);

        //Perform action te be tested
        List<User> foundUsers = this.userService.findAll();

        //Verifications & Assertions
        verify(userRepository, times(1)).findAll();
        assertEquals(2, foundUsers.size());
        assertThat(foundUsers, contains(expectedUsers.toArray()));
    }

    @Test
    public void testDelete() {

        //Create test data
        User expectedUser = buildUserKarel().build();

        //Mocking of Repository
        doNothing().when(userRepository).delete(expectedUser);

        //Execute method to be tested
        userService.delete(expectedUser);

        //Verifications & Assertions
        verify(userRepository, times(1)).delete(expectedUser);
    }

}
