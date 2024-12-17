package com.restaurantManagement.webapp.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class AuthRequestDTO {

    private String username;
    private String password;

}
