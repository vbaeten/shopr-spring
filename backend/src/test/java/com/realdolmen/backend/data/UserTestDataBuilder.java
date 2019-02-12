package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.User;

public class UserTestDataBuilder {

    public static User.Builder buildUserAmir(){
        return User.builder()
                .id(1L)
                .firstName("Amir")
                .name("Malik");
    }

    public static User.Builder buildUserKarel(){
        return User.builder()
                .id(2L)
                .firstName("Karel")
                .name("DeBruyne");
    }

    public static User.Builder buildNoArgsUser(){
        return User.builder();
    }

    public static User.Builder buildCustomArgsUserNoId(){
        return User.builder()
                .firstName("no")
                .name("id");

    }

}
