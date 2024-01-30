package com.example.demo.service;

import com.example.demo.model.ListeCadeaux;
import com.example.demo.repository.ListeCadeauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListeCadeauxService {
    @Autowired
    private ListeCadeauxRepository listeCadeauxRepository;

    public ListeCadeaux findByNom(String nom) {
        return listeCadeauxRepository.findByNom(nom);
    }
}
