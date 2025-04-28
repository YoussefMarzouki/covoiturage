package com.dsi.projet.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1, message = "La note doit être au moins 1.")
    @Max(value = 5, message = "La note doit être au plus 5.")
    private long rating;
    @NotBlank(message = "Le contenu ne peut pas être vide.")
    private String contenu;
    @PastOrPresent(message = "La date doit être dans le passé ou le présent.")
    private LocalDate date;

    @ManyToOne
    private User utilisateur;

    public Comment() {}

    public Comment(long rating, String contenu, LocalDate date, User utilisateur) {
        this.rating = rating;
        this.contenu = contenu;
        this.date = date;
        this.utilisateur = utilisateur;
    }

    public Long getId() { return id; }
    public long getRating() { return rating; }
    public String getContenu() { return contenu; }
    public LocalDate getDate() { return date; }
    public void setRating(long rating) { this.rating = rating; }
    public void setContenu(String contenu) { this.contenu = contenu; }
    public void setDate(LocalDate date) { this.date = date; }
}