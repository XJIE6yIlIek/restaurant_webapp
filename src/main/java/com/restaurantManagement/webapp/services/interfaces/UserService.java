package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.User;

public interface UserService {

    User getUserById(Long id);
    User getUserByUsername(String username);
    User createUser(User user);
    void deleteUser(Long id);
    User updateUser(User user);

}
