package com.example.demo.controller;

public class CadeauDTO {
    private String nom;
    private String description;
    private String prix;

    private String liste;

    public CadeauDTO() {
    }

    public CadeauDTO(String nom, String description, String prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public CadeauDTO(String nom, String description, String prix, String liste) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.liste = liste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getListe() {
        return liste;
    }

    public void setListe(String liste) {
        this.liste = liste;
    }
}
