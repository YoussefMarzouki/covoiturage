package com.dsi.projet.repositories;

import com.dsi.projet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Additional query methods can be defined here
}