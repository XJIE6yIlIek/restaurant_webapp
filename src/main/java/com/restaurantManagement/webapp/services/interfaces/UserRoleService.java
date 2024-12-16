package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.UserRole;
import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserRoleService {

    UserRole getRoleByName(String name);
    List<UserRole> getAllRoles();
    ResponseEntity<String> createRole(UserRoleDTO userRoleDTO);
    ResponseEntity<String> updateRole(UserRoleDTO userRoleDTO);
    void deleteRole(Long id);

}
