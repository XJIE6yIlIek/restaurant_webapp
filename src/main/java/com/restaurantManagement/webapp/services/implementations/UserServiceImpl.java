package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.UserRole;
import com.restaurantManagement.webapp.models.dtos.UserDTO;
import com.restaurantManagement.webapp.repositories.UserRepository;
import com.restaurantManagement.webapp.repositories.UserRoleRepository;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<User> createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserRole userRole = userRoleRepository.findByName(userDTO.getRole().getName());
        if (!Objects.isNull(userRole)) {
            user.setRole(userRole);
        } else {
            throw new IllegalArgumentException("Invalid user role: " + userDTO.getRole());
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<User> updateUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserRole userRole = userRoleRepository.findByName(userDTO.getRole().getName());
        if (!Objects.isNull(userRole)) {
            user.setRole(userRole);
        } else {
            throw new IllegalArgumentException("Invalid user role: " + userDTO.getRole());
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

}
