package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.models.dtos.DishDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();
    Dish getDishById(Long id);
    ResponseEntity<String> createDish(DishDTO dish);
    void deleteDish(Long id);
    ResponseEntity<String> updateDish(DishDTO dish);

}
