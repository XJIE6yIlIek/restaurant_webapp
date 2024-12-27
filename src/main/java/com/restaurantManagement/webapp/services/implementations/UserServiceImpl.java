package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.UserRole;
import com.restaurantManagement.webapp.models.dtos.UserDTO;
import com.restaurantManagement.webapp.repositories.UserRepository;
import com.restaurantManagement.webapp.repositories.UserRoleRepository;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        List<User> users = userRepository.findAll();
        users.forEach(user -> user.setPassword(null));
        return users;
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (!Objects.isNull(user)) {
            user.setPassword(null);
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        user.setPassword(null);
        return user;
    }

    @Override
    @Transactional
    public ResponseEntity<String> createUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        User user = new User();
        if (Objects.isNull(userRepository.findByUsername(username))) {
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            UserRole userRole = userRoleRepository.findByName(userDTO.getRole().getName());
            if (!Objects.isNull(userRole)) {
                user.setRole(userRole);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User role not found: " + userDTO.getRole().getName());
            }
            userRepository.save(user);
            return ResponseEntity.ok("User successfully created: " + username);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with such username already exists: " + username);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<String> updateUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        Long id = userDTO.getId();
        User user = userRepository.findById(id).orElse(null);

        if (Objects.isNull(userRepository.findByUsername(username)) && !Objects.isNull(user)) {
            user.setId(userDTO.getId());
            user.setUsername(userDTO.getUsername());
            if (!Objects.isNull(userDTO.getPassword())) {
                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
            UserRole userRole = userRoleRepository.findByName(userDTO.getRole().getName());
            if (!Objects.isNull(userRole)) {
                user.setRole(userRole);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User role not found: " + userDTO.getRole().getName());
            }
            userRepository.save(user);
            return ResponseEntity.ok("User successfully updated: " + username);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with such username already exists: " + id + username +
                                                                    "\nor user with such id doesn't exist: " + id);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
