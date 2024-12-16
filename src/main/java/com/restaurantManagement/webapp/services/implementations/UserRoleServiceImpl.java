package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.UserRole;
import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
import com.restaurantManagement.webapp.repositories.UserRoleRepository;
import com.restaurantManagement.webapp.services.interfaces.UserRoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole getRoleByName(String name) {
        return userRoleRepository.findByName(name);
    }

    @Override
    public List<UserRole> getAllRoles() {
        return userRoleRepository.findAll();
    }

    @Transactional
    @Override
    public ResponseEntity<String> createRole(UserRoleDTO userRoleDTO) {
        String roleName = userRoleDTO.getName();
        UserRole userRole = new UserRole();
        if (Objects.isNull(userRoleRepository.findByName(roleName))) {
            userRole.setName(roleName);
            userRoleRepository.save(userRole);
            return ResponseEntity.ok("User role successfully created: " + roleName);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User role already exists: " + roleName);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<String> updateRole(UserRoleDTO userRoleDTO) {
        Long id = userRoleDTO.getId();
        String roleName = userRoleDTO.getName();
        UserRole userRole = userRoleRepository.findById(id).orElse(null);

        if (Objects.isNull(userRoleRepository.findByName(roleName)) && !Objects.isNull(userRole)) {
            userRole.setId(id);
            userRole.setName(roleName);
            userRoleRepository.save(userRole);
            return ResponseEntity.ok("User role successfully updated: " + id + roleName);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User role already exists: " + roleName +
                                                                    "\nor user role with id doesn't exist: " + id);
        }
    }

    @Transactional
    @Override
    public void deleteRole(Long id) {
        userRoleRepository.deleteById(id);
    }

}
