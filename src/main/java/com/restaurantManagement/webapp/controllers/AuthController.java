package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.dtos.AuthRequestDTO;
import com.restaurantManagement.webapp.models.dtos.LoginResponseDTO;
import com.restaurantManagement.webapp.services.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody AuthRequestDTO authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userService.getUserByUsername(authRequest.getUsername());
        return new LoginResponseDTO(user.getUsername(), user.getRole().getName());
    }

}
