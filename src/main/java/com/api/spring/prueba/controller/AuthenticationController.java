package com.api.spring.prueba.controller;

import com.api.spring.prueba.dto.LogoutResponseDTO;
import com.api.spring.prueba.dto.auth.AutenticationRequestDTO;
import com.api.spring.prueba.dto.auth.AuthenticationResponseDTO;
import com.api.spring.prueba.dto.auth.RefreshTokenDTO;
import com.api.spring.prueba.model.security.User;
import com.api.spring.prueba.service.auth.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("permitAll")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody @Valid AutenticationRequestDTO autenticationRequestDTO){

        AuthenticationResponseDTO res = authenticationService.login(autenticationRequestDTO);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/validate-token")
    public ResponseEntity<Boolean> validate(@RequestParam String jwt){
        boolean isTokenValid = authenticationService.validateToken(jwt);
        return new ResponseEntity<>(isTokenValid, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<AuthenticationResponseDTO> refreshToken(@RequestBody RefreshTokenDTO refreshTokenDTO){
        System.out.println("jwt = " + refreshTokenDTO);
        AuthenticationResponseDTO res = authenticationService.refresToken(refreshTokenDTO.getToken());
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('READ_MY_PROFILE')")
    @GetMapping("/profile")
    public ResponseEntity<User> profile(){
        User user = authenticationService.findLoggedInUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponseDTO> logout(HttpServletRequest request){
        authenticationService.logout(request);
        return new ResponseEntity<>(new LogoutResponseDTO("logout exitoso"),HttpStatus.OK);
    }

}
