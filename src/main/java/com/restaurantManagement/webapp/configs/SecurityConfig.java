package com.restaurantManagement.webapp.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // TODO: make clients as non-authed users
        http
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/menu/**").permitAll();
                auth.requestMatchers("/profile").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN");
                auth.requestMatchers("/orders").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN");
                auth.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN");
                auth.requestMatchers("/admin/**").hasRole("ADMIN");
                auth.anyRequest().permitAll();
            })
            .formLogin((form -> form
                .loginPage("/login")
                .permitAll())
            )
            .logout(logout -> logout
                    .permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("employee")
                .password(passwordEncoder().encode("aaa"))
                .roles("EMPLOYEE")
                .build();
        UserDetails user2 = User.withUsername("manager")
                .password(passwordEncoder().encode("bbb"))
                .roles("MANAGER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("ccc"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }

}
