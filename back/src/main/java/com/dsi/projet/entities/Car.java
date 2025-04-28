package com.dsi.projet.entities;

import java.time.LocalDate;
import jakarta.validation.constraints.*;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @NotBlank(message = "L'ID de la voiture ne peut pas être vide.")
    private String id;
    @NotBlank(message = "La marque de la voiture ne peut pas être vide.")
    private String marque;
    @PastOrPresent(message = "L'année doit être dans le passé ou le présent.")
    @NotNull(message = "L'année ne peut pas être nulle.")
    private LocalDate annee;
    @Positive(message = "Le nombre de places doit être un nombre positif.")
    private int nbPlaces;
    @ManyToOne
    private Conductor conducteur;
    public Car() {}

    public Car(String id, String marque, LocalDate annee, int nbPlaces) {
        this.id = id;
        this.marque = marque;
        this.annee = annee;
        this.nbPlaces = nbPlaces;
    }

    public String getId() { return id; }
    public String getMarque() { return marque; }
    public LocalDate getAnnee() { return annee; }
    public int getNbPlaces() { return nbPlaces; }
    public void setMarque(String marque) { this.marque = marque; }
    public void setAnnee(LocalDate annee) { this.annee = annee; }
    public void setNbPlaces(int nbPlaces) { this.nbPlaces = nbPlaces; }
}