package com.dsi.projet.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @NotBlank(message = "L'ID ne peut pas être vide.")
    @NotNull(message = "L'ID ne peut pas être nul.")
    private String id;

    @NotBlank(message = "Le nom ne peut pas être vide.")
    private String nom;

    @NotBlank(message = "L'email ne peut pas être vide.")
    private String email;

    @Positive(message = "Le numéro de téléphone doit être un nombre positif.")
    private long telephone;

    @OneToMany(mappedBy = "utilisateur")
    private List<Comment> commentaires;

    public User() {}

    public User(String id, String nom, String email, long telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }

    public String getId() { return id; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public long getTelephone() { return telephone; }
    public void setNom(String nom) { this.nom = nom; }
    public void setEmail(String email) { this.email = email; }
    public void setTelephone(long telephone) { this.telephone = telephone; }
}