package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.CustomUser;
import com.restaurantManagement.webapp.models.modelsUtility.UserRole;
import com.restaurantManagement.webapp.repositories.UserRepository;
import com.restaurantManagement.webapp.services.implementations.utility.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService    {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = userRepository.findByUsername(username);
        if (Objects.isNull(user)) {
            return null;
        }

        return new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                loadAuthorities(user)
        );

    }

    private Collection<? extends GrantedAuthority> loadAuthorities(CustomUser user) {
        String userRole = user.getRole().toString();
        GrantedAuthority userAuthority = new SimpleGrantedAuthority(userRole);

        return List.of(userAuthority);
    }

    public CustomUser addUser(CustomUser user) {
        String decodedPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(decodedPassword);
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public CustomUser updateUser(CustomUser user) {
        return userRepository.save(user);
    }

    public void deleteUserByUsername(String username) {
        CustomUser user = userRepository.findByUsername(username);
        userRepository.deleteById(user.getId());
    }

}
