package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.UserRole;
import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
import com.restaurantManagement.webapp.repositories.UserRoleRepository;
import com.restaurantManagement.webapp.services.interfaces.UserRoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseEntity<UserRole> createRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = new UserRole();
        userRole.setName(userRoleDTO.getName());
        return ResponseEntity.ok(userRoleRepository.save(userRole));
    }

    @Transactional
    @Override
    public ResponseEntity<UserRole> updateRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = new UserRole();
        userRole.setName(userRoleDTO.getName());
        return ResponseEntity.ok(userRoleRepository.save(userRole));
    }

    @Transactional
    @Override
    public void deleteRole(Long id) {
        userRoleRepository.deleteById(id);
    }

}
