package com.restaurantManagement.webapp.controllers;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.services.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private DishService dishService;

    @GetMapping
    public String getAllDishes(Model model) {
        List<Dish> dishes = dishService.getAllDishes();
        List<Map<String, Object>> rows = new ArrayList<>();

        for (Dish dish : dishes) {
            Map<String, Object> row = new HashMap<>();
            row.put("id", dish.getId());
            row.put("name", dish.getName());
            row.put("description", dish.getDescription());
            row.put("weight", dish.getWeight());
            row.put("price", dish.getPrice());
            rows.add(row);
        }

        model.addAttribute("rows", rows);
        return "menu";
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable Long id) {
        return dishService.getDishById(id);
    }

}
