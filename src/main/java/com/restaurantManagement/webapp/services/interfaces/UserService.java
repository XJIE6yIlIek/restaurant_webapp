package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.dtos.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    ResponseEntity<String> createUser(UserDTO user);
    ResponseEntity<String> updateUser(UserDTO user);
    void deleteUser(Long id);

}
