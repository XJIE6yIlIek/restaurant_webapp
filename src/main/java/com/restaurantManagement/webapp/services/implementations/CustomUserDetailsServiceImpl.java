package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.models.CustomUser;
import com.restaurantManagement.webapp.repositories.UserRepository;
import com.restaurantManagement.webapp.services.implementations.utility.CustomUserDetails;
import com.restaurantManagement.webapp.services.interfaces.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public List<CustomUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public CustomUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<CustomUser> createUser(CustomUser user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<CustomUser> updateUser(CustomUser user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
