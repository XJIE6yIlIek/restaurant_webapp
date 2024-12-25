package com.restaurantManagement.webapp.utils;

import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import com.restaurantManagement.webapp.models.dtos.UserDTO;
import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
import com.restaurantManagement.webapp.repositories.OrderStatusRepository;
import com.restaurantManagement.webapp.services.implementations.*;
import com.restaurantManagement.webapp.services.interfaces.EventService;
import com.restaurantManagement.webapp.services.interfaces.OrderStatusService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRoleServiceImpl userRoleService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private OrderStatusServiceImpl orderStatusService;
    @Autowired
    private EventServiceImpl eventService;
    @Autowired
    private DishServiceImpl dishService;

    @Override
    public void run(String... args) throws Exception {
        UserRoleDTO adminRole = new UserRoleDTO("ADMIN");
        UserRoleDTO managerRole = new UserRoleDTO("MANAGER");
        UserRoleDTO employeeRole = new UserRoleDTO("EMPLOYEE");
        UserRoleDTO clientRole = new UserRoleDTO("CLIENT");
        userRoleService.createRole(adminRole);
        userRoleService.createRole(managerRole);
        userRoleService.createRole(employeeRole);
        userRoleService.createRole(clientRole);

        userService.createUser(new UserDTO("admin", "admin", adminRole));
        userService.createUser(new UserDTO("manager", "manager", managerRole));
        userService.createUser(new UserDTO("employee", "employee", employeeRole));
        userService.createUser(new UserDTO("client", "client", clientRole));

        OrderStatusDTO receivedStatus = new OrderStatusDTO("RECEIVED");
        OrderStatusDTO cookingStatus = new OrderStatusDTO("COOKING");
        OrderStatusDTO readyStatus = new OrderStatusDTO("READY");
        OrderStatusDTO deliveredStatus = new OrderStatusDTO("DELIVERED");
        orderStatusService.createStatus(receivedStatus);
        orderStatusService.createStatus(cookingStatus);
        orderStatusService.createStatus(readyStatus);
        orderStatusService.createStatus(deliveredStatus);
    }

}
