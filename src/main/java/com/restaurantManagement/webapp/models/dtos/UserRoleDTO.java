package com.restaurantManagement.webapp.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
public class UserRoleDTO {

    private Long id;
    private String name;

    public UserRoleDTO(String name) {
        this.name = name;
    }

}
