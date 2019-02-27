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

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userServiceImpl;


    UserService userService;

    private User user;

    @Before
    public void init() {
//        user = new User();
//        user.setId(1L);
//        user.setFirstName("Bernadette");
//        user.setName("Sanz");
//
//        MockitoAnnotations.initMocks(this);
//        userService = new UserServiceImpl(userMapper, userRepository);
    }

    @Test
    public void userCanByFoundById() {
        User user2 = userService.findById(1L);
        assertEquals(1L, user.getId().longValue());
    }
//
//    @Test
//    public void getAllUsers() throws Exception {
//        User user1 = new User();
//        user1.setId(1L);
//        user1.setFirstName("Ines");
//        user1.setName("Van Gucht");
//
//        User user2 = new User();
//        user2.setId(2L);
//        user2.setFirstName("Jutta");
//        user2.setName("Roggen");
//
//        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
//
//        List<UserDto> userDtos = userService.getAllUsers();
//
//        assertEquals(2, userDtos.size());
//
//    }
}




