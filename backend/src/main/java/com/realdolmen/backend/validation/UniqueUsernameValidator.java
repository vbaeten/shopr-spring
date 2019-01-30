package com.realdolmen.backend.validation;

import com.realdolmen.backend.repository.UserRepository;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private UserRepository repository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return username != null && repository.findByUsername(username) == null ;
    }

}