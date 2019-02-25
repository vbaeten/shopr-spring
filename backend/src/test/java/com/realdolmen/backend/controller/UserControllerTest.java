package com.realdolmen.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserAmir;
import static com.realdolmen.backend.data.UserTestDataBuilder.buildUserKarel;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    public void save() throws Exception {
        User expectedUser = buildUserKarel().build();
        when(userService.save(expectedUser)).thenReturn(expectedUser);

        String contentAsString = mockMvc.perform(
                post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expectedUser)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        User savedUser = objectMapper.readValue(contentAsString, User.class);

        assertThat(savedUser, allOf(
                hasProperty("id", equalTo(expectedUser.getId())),
                hasProperty("firstName", equalTo(expectedUser.getFirstName())),
                hasProperty("name", equalTo(expectedUser.getName()))
        ));
        verify(userService, times(1)).save(expectedUser);
    }

    @Test
    public void findById() throws Exception {
        User expectedUser = buildUserKarel().userName("karelDb").build();
        when(userService.findByUserName(expectedUser.getUserName())).thenReturn(expectedUser);

        String contentAsString = mockMvc.perform(get("/user/" + expectedUser.getUserName()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        User foundUser = objectMapper.readValue(contentAsString, User.class);

        assertThat(foundUser, allOf(
                hasProperty("id", equalTo(expectedUser.getId())),
                hasProperty("name", equalTo(expectedUser.getName())),
                hasProperty("firstName", equalTo(expectedUser.getFirstName()))
        ));
        verify(userService, times(1)).findByUserName(expectedUser.getUserName());

    }

    @Test
    public void findAll() throws Exception {
        List<User> expectedUsers = Arrays.asList(
                buildUserKarel().build(),
                buildUserAmir().build()
        );
        when(userService.findAll()).thenReturn(expectedUsers);

        String contentAsString = mockMvc.perform(get("/user"))
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<User> actualUsers = Arrays.stream(objectMapper.readValue(contentAsString, User[].class)).collect(Collectors.toList());
        assertThat(actualUsers.size(), is(expectedUsers.size()));
        assertThat(new ArrayList<>(actualUsers), contains(expectedUsers.toArray()));
        verify(userService, times(1)).findAll();
    }

    @Test
    @Ignore
    public void deleteById() throws Exception {
        User expectedUser = buildUserKarel().build();
        long id = 1L;
        when(userService.findById(id)).thenReturn(expectedUser);
        doNothing().when(userService).delete(expectedUser);

        mockMvc.perform(delete("/user/" + id))
                .andDo(print())
                .andExpect(status().isOk());

        verify(userService, times(1)).delete(expectedUser);
    }

}