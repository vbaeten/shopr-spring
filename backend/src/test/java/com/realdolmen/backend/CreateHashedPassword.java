package com.realdolmen.backend;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RunWith(MockitoJUnitRunner.class)
@Log4j2
public class CreateHashedPassword {
    @Test
    public void createHashedPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123456");
        String password2 = bCryptPasswordEncoder.encode("pass123");
        log.log(Level.DEBUG, password);
        log.log(Level.DEBUG, password2);
    }
}
