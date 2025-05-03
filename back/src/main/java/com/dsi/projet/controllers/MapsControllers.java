package com.dsi.projet.controllers;

import com.dsi.projet.entities.Maps;
import com.dsi.projet.services.MapsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")  // URL de base pour cette API
public class MapsControllers {
    private final MapsService nominatimService;

    // Injection de la dépendance NominatimService dans le contrôleur
    public MapsControllers(MapsService nominatimService) {
        this.nominatimService = nominatimService;
    }

    @GetMapping
    public List<Maps> search(@RequestParam String query) {
        System.out.println(query);
        return nominatimService.searchPlaces(query);
    }


}
