package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.models.dtos.DishDTO;
import com.restaurantManagement.webapp.repositories.DishRepository;
import com.restaurantManagement.webapp.services.interfaces.DishService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseEntity<Dish> createDish(DishDTO dishDTO) {
        Dish dish = new Dish();
        dish.setName(dishDTO.getName());
        dish.setDescription(dishDTO.getDescription());
        dish.setWeight(dishDTO.getWeight());
        dish.setPrice(dishDTO.getPrice());
        return ResponseEntity.ok(dishRepository.save(dish));
    }

    @Override
    @Transactional
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ResponseEntity<Dish> updateDish(DishDTO dishDTO) {
        Dish dish = new Dish();
        dish.setId(dishDTO.getId());
        dish.setName(dishDTO.getName());
        dish.setDescription(dishDTO.getDescription());
        dish.setWeight(dishDTO.getWeight());
        dish.setPrice(dishDTO.getPrice());
        return ResponseEntity.ok(dishRepository.save(dish));
    }

}
