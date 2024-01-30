package com.example.demo.controller;

import com.example.demo.model.Cadeau;

public class CadeauMapper {
    public static CadeauDTO convertToDTO(Cadeau entity) {
        CadeauDTO dto = new CadeauDTO();
        dto.setNom(entity.getNom());
        dto.setDescription(entity.getDescription());
        dto.setPrix(entity.getPrix() + "€");
        if(entity.getListeCadeaux() != null)
            dto.setListe(entity.getListeCadeaux().getNom());

        return dto;
    }

    public static Cadeau convertToEntity(CadeauDTO dto) {
        Cadeau entity = new Cadeau();
        entity.setNom(dto.getNom());
        entity.setDescription(dto.getDescription());
        entity.setPrix(Double.parseDouble(
                        dto.getPrix().replace("€", "")
        ));

        return entity;
    }
}
