package com.restaurantManagement.webapp.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilityBeans {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
