//package com.restaurantManagement.webapp;
//
//import com.restaurantManagement.webapp.models.CustomUser;
//import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
//import com.restaurantManagement.webapp.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public void run(String... args) throws Exception {
//        userRepository.save(new CustomUser("user", passwordEncoder.encode("password"), true, UserRole.valueOf("ADMIN")));
//    }
//}
