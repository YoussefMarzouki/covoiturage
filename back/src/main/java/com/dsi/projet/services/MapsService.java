package com.dsi.projet.services;

import com.dsi.projet.entities.Maps;

import java.util.List;

public interface MapsService {
    List<Maps> searchPlaces(String query);  // Recherche des lieux par nom
}
