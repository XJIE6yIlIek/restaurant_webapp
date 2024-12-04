package com.restaurantManagement.webapp.services.implementations;

import com.restaurantManagement.webapp.dto.UserDTO;
import com.restaurantManagement.webapp.models.User;
import com.restaurantManagement.webapp.repositories.UserRepository;
import com.restaurantManagement.webapp.services.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

}
