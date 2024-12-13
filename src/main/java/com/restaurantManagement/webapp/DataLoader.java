//package com.restaurantManagement.webapp;
//
//import com.restaurantManagement.webapp.models.dtos.UserDTO;
//import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
//import com.restaurantManagement.webapp.services.implementations.UserRoleServiceImpl;
//import com.restaurantManagement.webapp.services.implementations.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    private UserServiceImpl userService;
//    @Autowired
//    private UserRoleServiceImpl userRoleService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        UserRoleDTO adminDTO = new UserRoleDTO();
//        adminDTO.setName("ADMIN");
//        UserRoleDTO managerDTO = new UserRoleDTO();
//        managerDTO.setName("MANAGER");
//        UserRoleDTO employeeDTO = new UserRoleDTO();
//        employeeDTO.setName("EMPLOYEE");
//        UserRoleDTO clientDTO = new UserRoleDTO();
//        clientDTO.setName("CLIENT");
//        userRoleService.createRole(adminDTO);
//        userRoleService.createRole(managerDTO);
//        userRoleService.createRole(employeeDTO);
//        userRoleService.createRole(clientDTO);
//        UserDTO userDTO = new UserDTO();
//        userDTO.setRole(adminDTO);
//        userDTO.setUsername("admin");
//        userDTO.setPassword("admin");
//        userService.createUser(userDTO);
//    }
//
//}
