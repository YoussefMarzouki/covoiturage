package com.dsi.projet.controllers;

import com.dsi.projet.entities.Conductor;
import com.dsi.projet.entities.Trajet;
import com.dsi.projet.services.ConductorService;
import com.dsi.projet.services.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conductors")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;
    @Autowired
    private TrajetService trajetService;

    @GetMapping
    public List<Conductor> getAllConductors() {
        return conductorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conductor> getConductorById(@PathVariable String id) {
        Optional<Conductor> conductor = conductorService.findById(id);
        return conductor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Conductor createConductor(@RequestBody Conductor conductor) {
        return conductorService.save(conductor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conductor> updateConductor(@PathVariable String id, @RequestBody Conductor conductorDetails) {
        Optional<Conductor> conductor = conductorService.findById(id);
        if (conductor.isPresent()) {
            Conductor updatedConductor = conductor.get();
            updatedConductor.setRating(conductorDetails.getRating());
            // Update other fields as necessary
            return ResponseEntity.ok(conductorService.save(updatedConductor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConductor(@PathVariable String id) {
        conductorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public void addTrajetToConductor(String id, String id2) {
        
        Optional<Conductor> conductor = conductorService.findById(id);
        Optional<Trajet> trajet = trajetService.findById(id2);
        if (conductor.isPresent() && trajet.isPresent()) {
            Conductor updatedConductor = conductor.get();
            Trajet trajetToAdd = trajet.get();
            updatedConductor.addTrajets(trajetToAdd);
            trajetToAdd.setConducteur(updatedConductor);
            conductorService.save(updatedConductor);
        }
    }
}