package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);
    User getUserByUsername(String username);
    User createUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);

}
