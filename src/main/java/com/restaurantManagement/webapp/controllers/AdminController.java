package com.restaurantManagement.webapp.controllers;


import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users-list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }



}
