package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.dto.UserDTO;
import com.restaurantManagement.webapp.models.User;

public interface UserService {

    User getUserById(Long id);
    User getUserByUsername(String username);

    UserDTO createUser(UserDTO userDTO);

    void deleteUser(Long id);
    User updateUser(User user);

}
