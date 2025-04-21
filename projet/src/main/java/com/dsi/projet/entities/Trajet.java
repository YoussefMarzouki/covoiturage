package com.dsi.projet.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;


@Entity
public class Trajet {
    @Id
    @NotBlank(message = "L'ID du trajet ne peut pas être vide.")
    private String id;
    @NotBlank(message = "Le lieu de départ ne peut pas être vide.")
    private String depart;
    @NotBlank(message = "La destination ne peut pas être vide.")
    private String destination;
    @FutureOrPresent(message = "La date doit être dans le futur ou le présent.")
    private LocalDate date;
    @PositiveOrZero(message = "Le nombre de places doit être un nombre positif.")
    private int placesDisponibles;

    @ManyToOne
    private Conductor conducteur;

    public Trajet() {}

    public Trajet(String id, String depart, String destination, LocalDate date, int placesDisponibles) {
        this.id = id;
        this.depart = depart;
        this.destination = destination;
        this.date = date;
        this.placesDisponibles = placesDisponibles;
        
    }

    public String getId() { return id; }
    public String getDepart() { return depart; }
    public String getDestination() { return destination; }
    public LocalDate getDate() { return date; }
    public int getPlacesDisponibles() { return placesDisponibles; }
    public void setDepart(String depart) { this.depart = depart; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setPlacesDisponibles(int placesDisponibles) { this.placesDisponibles = placesDisponibles; }
    public void setConducteur(Conductor conducteur) { this.conducteur = conducteur; }
}