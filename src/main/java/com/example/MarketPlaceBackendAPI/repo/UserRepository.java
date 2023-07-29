package com.example.MarketPlaceBackendAPI.repo;

import com.example.MarketPlaceBackendAPI.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User save(User user);
}
