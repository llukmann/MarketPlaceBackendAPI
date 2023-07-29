package com.example.MarketPlaceBackendAPI.service;

import com.example.MarketPlaceBackendAPI.models.User;

import java.util.List;


public interface UserService {
    User findByUsername(String username);
    List<User> findAll();
    User findById(Long id);
    User create(User user);
}
