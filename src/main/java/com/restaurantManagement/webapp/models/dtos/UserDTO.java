package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private UserRoleDTO role;

    public UserDTO(String username, String password, UserRoleDTO role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
