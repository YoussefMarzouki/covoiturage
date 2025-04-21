package com.dsi.projet.repositories;

import com.dsi.projet.entities.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, String> {
    // Additional query methods can be defined here
}