package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.dto.UserDTO;
import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
//    @Autowired
//    PasswordEncoder passwordEncoder;

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

    @GetMapping("/create")
    public String getUserForm(Model model) {

        return "user-creation";
    }

    // TODO: edit after altering user system
    @PostMapping("/create")
    public String saveUser(@RequestBody UserDTO userDTO) {

        userService.createUser(userDTO);

        return "redirect:/create";

    }

}
