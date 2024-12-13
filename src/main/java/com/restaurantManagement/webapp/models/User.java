package com.restaurantManagement.webapp.models;

import jakarta.persistence.*;
import lombok.*;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private UserRole role;

    public User(String username, String password, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.role = userRole;
    }
}
