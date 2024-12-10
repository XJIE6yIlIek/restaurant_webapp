package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.CustomUser;
import com.restaurantManagement.webapp.models.dtos.CustomUserDTO;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping
    public List<CustomUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public CustomUser getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomUser> createUser(@RequestBody CustomUserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CustomUser> updateUser(@PathVariable("id") Long id, @RequestBody CustomUserDTO userDTO) {
        userDTO.setId(id);
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
