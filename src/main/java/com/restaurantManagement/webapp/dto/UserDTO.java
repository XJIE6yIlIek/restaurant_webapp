package com.restaurantManagement.webapp.dto;

import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private int id;
    private String username;
    private String password;
    private UserRole role;

}
