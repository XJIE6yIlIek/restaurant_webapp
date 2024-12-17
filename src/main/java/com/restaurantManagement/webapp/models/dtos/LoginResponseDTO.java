package com.restaurantManagement.webapp.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    private String username;
    private String role;

}
