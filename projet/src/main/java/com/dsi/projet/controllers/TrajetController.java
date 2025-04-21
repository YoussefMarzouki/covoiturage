package com.dsi.projet.controllers;

import com.dsi.projet.entities.Trajet;
import com.dsi.projet.services.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trajets")
public class TrajetController {

    @Autowired
    private TrajetService trajetService;

    @GetMapping
    public List<Trajet> getAllTrajets() {
        return trajetService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trajet> getTrajetById(@PathVariable String id) {
        Optional<Trajet> trajet = trajetService.findById(id);
        return trajet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trajet createTrajet(@RequestBody Trajet trajet) {
        return trajetService.save(trajet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trajet> updateTrajet(@PathVariable String id, @RequestBody Trajet trajetDetails) {
        Optional<Trajet> trajet = trajetService.findById(id);
        if (trajet.isPresent()) {
            Trajet updatedTrajet = trajet.get();
            updatedTrajet.setDepart(trajetDetails.getDepart());
            updatedTrajet.setDestination(trajetDetails.getDestination());
            updatedTrajet.setDate(trajetDetails.getDate());
            updatedTrajet.setPlacesDisponibles(trajetDetails.getPlacesDisponibles());
            return ResponseEntity.ok(trajetService.save(updatedTrajet));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrajet(@PathVariable String id) {
        trajetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
