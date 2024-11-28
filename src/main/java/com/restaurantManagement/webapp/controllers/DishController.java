package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.services.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
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

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Dish addDish(@RequestBody @Validated Dish dish) {
        return dishService.addDish(dish);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Dish updateDish(@RequestBody Dish dish) {
        return dishService.updateDish(dish);
    }

}
