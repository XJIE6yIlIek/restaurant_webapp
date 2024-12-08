package com.restaurantManagement.webapp.models;

import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "users")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Column(name = "user_enabled", nullable = false)
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole role;

}
