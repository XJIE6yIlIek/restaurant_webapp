package com.restaurantManagement.webapp.models.dtos;

import com.restaurantManagement.webapp.models.UserRole;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private UserRoleDTO role;

}
