package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "listes_cadeaux")
public class ListeCadeaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;

    public ListeCadeaux() {
    }

    public ListeCadeaux(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}