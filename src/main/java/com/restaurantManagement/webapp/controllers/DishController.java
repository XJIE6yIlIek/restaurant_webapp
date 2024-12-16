package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.models.dtos.DishDTO;
import com.restaurantManagement.webapp.services.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public Dish getDishById(@PathVariable("id") Long id) {
        return dishService.getDishById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDish(@RequestBody DishDTO dishDTO) {
        return dishService.createDish(dishDTO);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateDish(@PathVariable("id") Long id, @RequestBody DishDTO dishDTO) {
        dishDTO.setId(id);
        return dishService.updateDish(dishDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDish(@PathVariable("id") Long id) {
        dishService.deleteDish(id);
    }

}
