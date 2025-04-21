package com.dsi.projet.services;

import com.dsi.projet.entities.Conductor;

import java.util.List;
import java.util.Optional;

public interface ConductorService {
    List<Conductor> findAll();
    Optional<Conductor> findById(String id);
    Conductor save(Conductor conductor);
    void deleteById(String id);
    boolean deposerTrajet(String id, String idTrajet);
}