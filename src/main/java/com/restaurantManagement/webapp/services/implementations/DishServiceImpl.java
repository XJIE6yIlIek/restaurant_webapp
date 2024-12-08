package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.Dish;
import com.restaurantManagement.webapp.repositories.DishRepository;
import com.restaurantManagement.webapp.services.interfaces.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

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
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    @Override
    public Dish updateDish(Dish dish) {
        return dishRepository.save(dish);
    }

}
