package com.dsi.projet.services;

import com.dsi.projet.entities.Conductor;
import com.dsi.projet.repositories.ConductorRepository;
import com.dsi.projet.repositories.TrajetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;
    @Autowired
    private TrajetRepository trajetRepository;

    @Override
    public List<Conductor> findAll() {
        return conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> findById(String id) {
        return conductorRepository.findById(id);
    }

    @Override
    public Conductor save(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public void deleteById(String id) {
        conductorRepository.deleteById(id);
    }

    @Override
    public boolean deposerTrajet(String id, String idTrajet) {
        Optional<Conductor> conductor = conductorRepository.findById(id);
        if (conductor.isPresent()) {
            conductor.get().getTrajets().add(trajetRepository.findById(idTrajet).get());
            conductorRepository.save(conductor.get());
            return true;
        }
        return false;
    }
}