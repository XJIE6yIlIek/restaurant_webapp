package com.restaurantManagement.webapp.models.dtos;

import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CustomUserDTO {

    private Long id;
    private String username;
    private String password;
    private boolean enabled;
    private String role;

}
