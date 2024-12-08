package com.restaurantManagement.webapp.services.interfaces;

import com.restaurantManagement.webapp.models.Dish;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();
    Dish getDishById(Long id);
    Dish createDish(Dish dish);
    void deleteDish(Long id);
    Dish updateDish(Dish dish);

}
