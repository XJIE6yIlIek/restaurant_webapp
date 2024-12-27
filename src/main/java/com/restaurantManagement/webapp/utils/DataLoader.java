package com.restaurantManagement.webapp.utils;

import com.restaurantManagement.webapp.models.dtos.DishDTO;
import com.restaurantManagement.webapp.models.dtos.OrderStatusDTO;
import com.restaurantManagement.webapp.models.dtos.UserDTO;
import com.restaurantManagement.webapp.models.dtos.UserRoleDTO;
import com.restaurantManagement.webapp.services.implementations.*;
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
        UserRoleDTO adminRole = new UserRoleDTO("ROLE_ADMIN");
        UserRoleDTO managerRole = new UserRoleDTO("ROLE_MANAGER");
        UserRoleDTO employeeRole = new UserRoleDTO("ROLE_EMPLOYEE");
        UserRoleDTO clientRole = new UserRoleDTO("ROLE_CLIENT");
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

        DishDTO soupDish = new DishDTO("Soup", "Cheap soup", 0.5F, 100F);
        DishDTO saladDish = new DishDTO("Salad", "Vegetarian food", 0.2F, 150F);
        DishDTO chickenDish = new DishDTO("Chicken", "Big chicken meal", 1F, 300F);
        DishDTO sodaDish = new DishDTO("Soda", "Soda. Just soda", 0.33F, 70F);
        dishService.createDish(soupDish);
        dishService.createDish(saladDish);
        dishService.createDish(chickenDish);
        dishService.createDish(sodaDish);
    }

}
