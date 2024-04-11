package com.microservices.identityservice.controller;

import com.microservices.identityservice.core.model.User;
import com.microservices.identityservice.core.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    @NonNull
    private UserService userService;

    @GetMapping
    public User getMe() {
        return userService.getMe();
    }
}
