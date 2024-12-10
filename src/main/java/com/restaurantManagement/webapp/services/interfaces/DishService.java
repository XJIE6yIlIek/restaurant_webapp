package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.models.dtos.DishDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();
    Dish getDishById(Long id);
    ResponseEntity<Dish> createDish(DishDTO dish);
    void deleteDish(Long id);
    ResponseEntity<Dish> updateDish(DishDTO dish);

}
