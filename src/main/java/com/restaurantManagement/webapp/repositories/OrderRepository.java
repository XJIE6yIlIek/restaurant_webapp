package com.restaurantManagement.webapp.repositories;

import com.restaurantManagement.webapp.models.Order;
import com.restaurantManagement.webapp.models.modelsUtility.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);

}
