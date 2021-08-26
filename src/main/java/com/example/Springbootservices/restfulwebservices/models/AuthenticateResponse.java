package com.example.Springbootservices.restfulwebservices.models;

public class AuthenticateResponse {

    private final String jwt;

    public AuthenticateResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
