package com.realdolmen.backend.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
