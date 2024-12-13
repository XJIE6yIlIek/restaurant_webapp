package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.UserRole;
import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRoleService {

    UserRole getRoleByName(String name);
    List<UserRole> getAllRoles();
    ResponseEntity<UserRole> createRole(UserRoleDTO userRoleDTO);
    ResponseEntity<UserRole> updateRole(UserRoleDTO userRoleDTO);
    void deleteRole(Long id);

}
