package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public User getUserInfo() {
        User user = new User();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Object credentials = auth.getCredentials();

        user.setUsername(username);
        user.setPassword((String) credentials);

        return user;
    }

    @PostMapping("/create")
    public String createUser(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("role") UserRole role) {
        if (!Objects.isNull(userService.getUserByUsername(username))) {
            return "redirect:/create?error=duplicate";
        }

        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        userService.createUser(user);

        return "redirect:/create?success";
    }

}
