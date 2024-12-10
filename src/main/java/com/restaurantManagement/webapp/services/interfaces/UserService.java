package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.CustomUser;
import com.restaurantManagement.webapp.models.dtos.CustomUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {

    List<CustomUser> getAllUsers();
    CustomUser getUserById(Long id);
    ResponseEntity<CustomUser> createUser(CustomUserDTO user);
    void deleteUser(Long id);
    ResponseEntity<CustomUser> updateUser(CustomUserDTO user);

}
