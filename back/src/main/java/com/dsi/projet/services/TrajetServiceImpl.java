package com.dsi.projet.services;

import com.dsi.projet.entities.Trajet;
import com.dsi.projet.repositories.TrajetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrajetServiceImpl implements TrajetService {

    @Autowired
    private TrajetRepository trajetRepository;

    @Override
    public List<Trajet> findAll() {
        return trajetRepository.findAll();
    }

    @Override
    public Optional<Trajet> findById(String id) {
        return trajetRepository.findById(id);
    }

    @Override
    public Trajet save(Trajet trajet) {
        return trajetRepository.save(trajet);
    }

    @Override
    public void deleteById(String id) {
        trajetRepository.deleteById(id);
    }
}