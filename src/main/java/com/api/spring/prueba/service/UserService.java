package com.api.spring.prueba.service;

import com.api.spring.prueba.dto.SaveUserDTO;
import com.api.spring.prueba.model.security.User;

import java.util.Optional;

public interface UserService {
    User createCustomer(SaveUserDTO saveUser);

    Optional<User> findByUsername(String username);
}
