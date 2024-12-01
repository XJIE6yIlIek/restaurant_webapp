//package com.restaurantManagement.webapp.configs;
//
//
//import com.restaurantManagement.webapp.services.implementations.UserServiceImpl;
//import com.restaurantManagement.webapp.services.interfaces.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> {
//                auth.requestMatchers("/admin/**").hasRole("ADMIN");
//                auth.requestMatchers("/manager/**").hasRole("MANAGER");
//                auth.requestMatchers("/employee/**").hasRole("EMPLOYEE");
//                auth.requestMatchers("/client/**").hasRole("CLIENT");
//                auth.anyRequest().permitAll();
//            })
//            .formLogin((form -> form
//                .loginPage("/login")
//                .permitAll())
//            )
//            .logout(logout -> logout.permitAll());
//        return http.build();
//    }
//
//    @Bean
//    public UserService userService() {
//        return new UserServiceImpl();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
