package com.microservices.identityservice.controller;

import com.microservices.identityservice.core.dto.SignUpRequest;
import com.microservices.identityservice.core.service.AuthService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @NonNull
    private final AuthService authService;

    @PostMapping(value = "/admin/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String signUp(@RequestBody SignUpRequest signUpRequest) {
        return authService.signUp(signUpRequest.getEmail(), signUpRequest.getPassword());
    }

    @PostMapping(value = "/admin/sign-in", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String signIn(@RequestBody SignUpRequest signUpRequest) {
        return authService.signIn(signUpRequest.getEmail(), signUpRequest.getPassword());
    }
}
