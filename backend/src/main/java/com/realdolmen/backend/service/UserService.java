package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Role;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.RoleRepository;
import com.realdolmen.backend.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder encoder;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder encoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;
    }

    public User create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("CUSTOMER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.saveAndFlush(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String userName) throws NotFoundException {
        return userRepository.findByUsername(userName).orElseThrow(() -> new NotFoundException("Not a registered user"));
    }

    public Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user.getId();
    }

}
