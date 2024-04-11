package com.microservices.identityservice.core.service;

import com.microservices.identityservice.core.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService userDetailsService();

    User getCurrentUser();

    User getMe();
}
