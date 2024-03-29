package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cadeaux")
public class Cadeau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String description;
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "liste_cadeaux_id")
    private ListeCadeaux listeCadeaux;

    public Cadeau() {
    }

    public Cadeau(String nom, String description, Double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ListeCadeaux getListeCadeaux() {
        return listeCadeaux;
    }

    public void setListeCadeaux(ListeCadeaux listeCadeaux) {
        this.listeCadeaux = listeCadeaux;
    }

    @Override
    public String toString() {
        return "Cadeau{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                '}';
    }
}