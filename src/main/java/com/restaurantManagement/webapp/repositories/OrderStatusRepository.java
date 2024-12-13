package com.restaurantManagement.webapp.repositories;

import com.restaurantManagement.webapp.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    OrderStatus findByName(String name);

}
