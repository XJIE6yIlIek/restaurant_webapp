package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.CustomUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.net.http.HttpResponse;
import java.util.List;

public interface CustomUserDetailsService extends UserDetailsService {

    List<CustomUser> getAllUsers();
    CustomUser getUserById(Long id);
    ResponseEntity<CustomUser> createUser(CustomUser user);
    void deleteUser(Long id);
    ResponseEntity<CustomUser> updateUser(CustomUser user);

}
