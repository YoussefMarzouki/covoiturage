package com.dsi.projet.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conductor extends User {
    private long rating;

    @OneToMany(mappedBy = "conducteur")
    private List<Trajet> trajets;

    @OneToMany(mappedBy = "conducteur")
    private List<Car> voitureList = new ArrayList<>();

    public Conductor() {}

    public Conductor(String id, String nom, String email, long telephone, long rating, Car voiture) {
        super(id, nom, email, telephone);
        this.rating = rating;
        this.voitureList.add(voiture);
    }

    public long getRating() { return rating; }
    public void setRating(long rating) { this.rating = rating; }
    public List<Trajet> getTrajets() { return trajets; }
    public void addTrajets(Trajet trajet) { this.trajets.add( trajet); }
    public List<Car> getVoitureList() { return voitureList; }
    public void addVoitureList(Car voiture) { this.voitureList.add(voiture); } 
}