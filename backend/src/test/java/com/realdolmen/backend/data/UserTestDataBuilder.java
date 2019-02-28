package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.dto.UserDto;

public class UserTestDataBuilder {

    public static User.Builder buildUserBernadetteSanz() {
        return User.builder().id(1L).firstName("Bernadette").name("Sanz");
    }

    public static UserDto.Builder buildUserDtoBernadetteSanz() {
        return UserDto.builder().id(1L).firstName("Bernadette").name("Sanz");
    }

    public static User.Builder buildUserJuttaRoggen() {
        return User.builder().id(2L).firstName("Jutta").name("Roggen");
    }

    public static UserDto.Builder buildUserDtoJuttaRoggen() {
        return UserDto.builder().id(2L).firstName("Jutta").name("Roggen");
    }
}
