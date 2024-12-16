package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.models.dtos.DishDTO;
import com.restaurantManagement.webapp.repositories.DishRepository;
import com.restaurantManagement.webapp.services.interfaces.DishService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DishServiceImpl implements DishService { // TODO: make it so some methods return responseentity as in CustomUserDetailsServiceImpl

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<String> createDish(DishDTO dishDTO) {
        String dishName = dishDTO.getName();
        Dish dish = new Dish();
        dish.setName(dishDTO.getName());
        dish.setDescription(dishDTO.getDescription());
        dish.setWeight(dishDTO.getWeight());
        dish.setPrice(dishDTO.getPrice());
        dishRepository.save(dish);
        return ResponseEntity.ok("Dish successfully created: " + dishName);
    }

    @Override
    @Transactional
    public ResponseEntity<String> updateDish(DishDTO dishDTO) {
        Long id = dishDTO.getId();
        String dishName = dishDTO.getName();
        Dish dish = dishRepository.findById(id).orElse(null);
        if (!Objects.isNull(dish)) {
            dish.setId(dishDTO.getId());
            dish.setName(dishDTO.getName());
            dish.setDescription(dishDTO.getDescription());
            dish.setWeight(dishDTO.getWeight());
            dish.setPrice(dishDTO.getPrice());
            dishRepository.save(dish);
            return ResponseEntity.ok("Dish successfully updated: " + id + dishName);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Dish with id doesn't exist: " + id);
        }
    }

    @Override
    @Transactional
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

}
