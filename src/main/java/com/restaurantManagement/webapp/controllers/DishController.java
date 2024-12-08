package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.services.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable Long id) {
        return dishService.getDishById(id);
    }

    @PostMapping("/create")
    public Dish createDish(@RequestParam Dish dish) {
        return dishService.createDish(dish);
    }

    @PostMapping("/update")
    public Dish updateDish(@RequestParam Dish dish) {
        return dishService.updateDish(dish);
    }

    @DeleteMapping("/delete")
    public void deleteDish(Long id) {
        dishService.deleteDish(id);
    }

}
