package com.realdolmen.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class UserDto {

    @NotEmpty(message = "Please enter your firstname")
    private String firstname;

    @NotEmpty(message = "Please enter your lastname")
    private String lastname;

    @NotEmpty(message = "Please enter a username")
    private String username;

    @NotEmpty(message = "Please enter in a password")
    private String password;

    @NotEmpty(message = "Please confirm your password")
    private String confirmPassword;
}
