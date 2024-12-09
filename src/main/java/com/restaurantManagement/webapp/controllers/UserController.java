package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.CustomUser;
import com.restaurantManagement.webapp.services.interfaces.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public List<CustomUser> getAllUsers() {
        return userDetailsService.getAllUsers();
    }

    @GetMapping("/{id}")
    public CustomUser getUserById(@PathVariable("id") Long id) {
        return userDetailsService.getUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomUser> createUser(@RequestBody CustomUser user) {
        return userDetailsService.createUser(user);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CustomUser> updateUser(@PathVariable("id") Long id, @RequestBody CustomUser user) {
        user.setId(id);
        return userDetailsService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userDetailsService.deleteUser(id);
    }

}
