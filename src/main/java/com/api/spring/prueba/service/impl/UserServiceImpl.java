package com.api.spring.prueba.service.impl;

import com.api.spring.prueba.dto.SaveUserDTO;
import com.api.spring.prueba.exception.InvalidPasswordException;
import com.api.spring.prueba.exception.ObjectNotFoundException;
import com.api.spring.prueba.model.security.Role;
import com.api.spring.prueba.model.security.User;
import com.api.spring.prueba.repository.security.UserRepository;
import com.api.spring.prueba.service.RoleService;
import com.api.spring.prueba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Override
    public User createCustomer(SaveUserDTO saveUserDto){

        validatePassword(saveUserDto);

        User user = new User();

        user.setName(saveUserDto.getName());
        user.setUsername(saveUserDto.getUsername());

        Role defaultRole = roleService.findDefaultRole()
                .orElseThrow(() -> new ObjectNotFoundException("Default role not found"));

        user.setRole(defaultRole);
        user.setPassword(passwordEncoder.encode(saveUserDto.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    private void validatePassword(SaveUserDTO saveUserDto){

        // Verificar que las contraseñas no estén vacías
        if (!StringUtils.hasText(saveUserDto.getPassword())) {
            throw new InvalidPasswordException("Password cannot be empty");
        }

        if (!StringUtils.hasText(saveUserDto.getRepeatPassword())) {
            throw new InvalidPasswordException("Repeat password cannot be empty");
        }

        // Verificar que las contraseñas coincidan
        if (!saveUserDto.getPassword().equals(saveUserDto.getRepeatPassword())) {
            throw new InvalidPasswordException("Passwords do not match");
        }
    }

}
