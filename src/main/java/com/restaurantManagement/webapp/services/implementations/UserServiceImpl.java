package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.CustomUser;
import com.restaurantManagement.webapp.models.dtos.CustomUserDTO;
import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import com.restaurantManagement.webapp.repositories.UserRepository;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<CustomUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public CustomUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<CustomUser> createUser(CustomUserDTO userDTO) {
        CustomUser user = new CustomUser();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(true);
        try {
            user.setRole(UserRole.valueOf(userDTO.getRole()));
        } catch (IllegalArgumentException e) {
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
    public ResponseEntity<CustomUser> updateUser(CustomUserDTO userDTO) {
        CustomUser user = new CustomUser();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(true);
        try {
            user.setRole(UserRole.valueOf(userDTO.getRole()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid user role: " + userDTO.getRole());
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

}
