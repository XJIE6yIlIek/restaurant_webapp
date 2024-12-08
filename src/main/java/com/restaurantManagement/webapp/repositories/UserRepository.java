package com.restaurantManagement.webapp.repositories;


import com.restaurantManagement.webapp.models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    CustomUser findByUsername(String username);

}
