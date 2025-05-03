package com.dsi.projet.services;

import com.dsi.projet.entities.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MapsServiceImpl implements MapsService {

    @Value("${nominatim.url}")  // Charge l'URL de l'API depuis application.properties
    private String nominatimUrl;

    //classe fournie par Spring qui permet de faire des appels HTTP (GET, POST, PUT, DELETE) à des services externes, comme une API.
    private final RestTemplate restTemplate;

    // Constructeur pour injecter RestTemplate
    public MapsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Maps> searchPlaces(String query) {

        String url = nominatimUrl.replace("{query}", query);
        System.out.println("URL appelée : " + url); // Debug

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "MyApp/1.0 (dhaouieya00@gmail.com)");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<List<Maps>> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<Maps>>() {}
            );
            return response.getBody();
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
            return null;
        }
    }
}
