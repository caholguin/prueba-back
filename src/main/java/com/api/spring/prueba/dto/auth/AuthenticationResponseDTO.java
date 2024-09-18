package com.api.spring.prueba.dto.auth;

import java.io.Serializable;

public class AuthenticationResponseDTO implements Serializable {

    private String jwt;

    public String getJwt(){
        return jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }
}
