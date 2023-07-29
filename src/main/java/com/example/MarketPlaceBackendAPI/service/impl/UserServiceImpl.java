package com.example.MarketPlaceBackendAPI.service.impl;

import com.example.MarketPlaceBackendAPI.models.User;
import com.example.MarketPlaceBackendAPI.repo.UserRepository;
import com.example.MarketPlaceBackendAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);
        return result;
    }

    @Override
    public User create(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }
}
