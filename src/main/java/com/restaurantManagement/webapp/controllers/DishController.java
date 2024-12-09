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
    public Dish getDishById(@PathVariable("id") Long id) {
        return dishService.getDishById(id);
    }

    @PostMapping("/create")
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.createDish(dish);
    }

    @PostMapping("/update/{id}")
    public Dish updateDish(@PathVariable("id") Long id, @RequestBody Dish dish) {
        dish.setId(id);
        return dishService.updateDish(dish);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDish(@PathVariable("id") Long id) {
        dishService.deleteDish(id);
    }

}
