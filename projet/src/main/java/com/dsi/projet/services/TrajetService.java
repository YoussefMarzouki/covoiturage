package com.dsi.projet.services;

import com.dsi.projet.entities.Trajet;

import java.util.List;
import java.util.Optional;

public interface TrajetService {
    List<Trajet> findAll();
    Optional<Trajet> findById(String id);
    Trajet save(Trajet trajet);
    void deleteById(String id);
}