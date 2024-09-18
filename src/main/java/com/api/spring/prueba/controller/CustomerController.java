package com.api.spring.prueba.controller;

import com.api.spring.prueba.dto.RegisteredUserDTO;
import com.api.spring.prueba.dto.SaveUserDTO;
import com.api.spring.prueba.model.security.User;
import com.api.spring.prueba.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping
    public ResponseEntity<RegisteredUserDTO> register(@RequestBody @Valid SaveUserDTO saveUser){
        RegisteredUserDTO registerUser = authenticationService.registerCustomer(saveUser);
        return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(Arrays.asList(),HttpStatus.OK);
    }
}
