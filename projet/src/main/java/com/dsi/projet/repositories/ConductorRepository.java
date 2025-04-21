package com.dsi.projet.repositories;

import com.dsi.projet.entities.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, String> {
    // Additional query methods can be defined here
}