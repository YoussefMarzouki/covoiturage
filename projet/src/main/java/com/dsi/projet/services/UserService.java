package com.dsi.projet.services;

import com.dsi.projet.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(String id);
    User save(User user);
    void deleteById(String id);
}