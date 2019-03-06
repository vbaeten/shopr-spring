package com.realdolmen.backend.controller;

import com.realdolmen.backend.data.UserTestDataBuilder;
import com.realdolmen.backend.dto.UserDto;
import com.realdolmen.backend.facade.UserFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    UserFacade userFacade;

    @InjectMocks
    UserController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new UserController(userFacade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

//    @Test
//    public void registerUser() throws Exception {
//        UserDto userDto = new UserDto();
//        userDto.setId(2L);
//        userDto.setFirstName("Bernie");
//        userDto.setName("Sanz");
//
//        when(userFacade.createUser(any())).thenReturn(userDto);
//
//        mockMvc.perform(post("/user/register").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        verify(userFacade, times(1)).createUser(userDto);
//    }


    @Test
    public void getUserById() throws Exception {

        UserDto userDto = UserTestDataBuilder.buildUserDtoBernadetteSanz().build();

        when(userFacade.findById(anyLong())).thenReturn(userDto);

        mockMvc.perform(get("/user/1"))
                .andExpect(status()
                        .isOk());

        verify(userFacade, times(1)).findById(anyLong());
    }



    @Test
    public void deleteUserById() throws Exception {
        mockMvc.perform(delete("/user/delete/1"))
                .andExpect(status()
                        .isOk());

        verify(userFacade, times(1)).deleteById(any());
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(delete("/user/delete"))
                .andExpect(status().isOk());

        verify(userFacade, times(1)).delete(any());
    }
}
