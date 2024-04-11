package com.microservices.identityservice.core.service;

public interface AuthService {

    String signUp(String email, String password);

    String signIn(String email, String password);
}

