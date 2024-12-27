package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.UserRole;
import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
import com.restaurantManagement.webapp.services.implementations.UserRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/roles")
public class UserRoleController {

    @Autowired
    private UserRoleServiceImpl userRoleService;

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllRoles();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        return userRoleService.createRole(userRoleDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateUserRole(@PathVariable("id") Long id, @RequestBody UserRoleDTO userRoleDTO) {
        userRoleDTO.setId(id);
        return userRoleService.updateRole(userRoleDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserRole(@PathVariable("id") Long id) {
        userRoleService.deleteRole(id);
    }

}
