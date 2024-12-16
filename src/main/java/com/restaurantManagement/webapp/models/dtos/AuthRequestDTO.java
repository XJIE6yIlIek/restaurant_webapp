package com.restaurantManagement.webapp.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class AuthRequestDTO {

    private String username;
    private String password;

}
