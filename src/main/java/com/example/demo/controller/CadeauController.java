package com.example.demo.controller;

import com.example.demo.model.Cadeau;
import com.example.demo.service.CadeauService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CadeauController {
    @Autowired
    private CadeauService cadeauService;


    @GetMapping("cadeaux")
    public List<CadeauDTO> getAll() {
        //List<CadeauDTO> dtos = new ArrayList<>();
        return cadeauService.findAll()
                            .stream().map(CadeauMapper::convertToDTO)
                            .toList();
    }

    @GetMapping("cadeaux/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<Cadeau> optionalCadeau = cadeauService.findById(id);

        if(optionalCadeau.isPresent()) {
            CadeauDTO dto = CadeauMapper.convertToDTO(optionalCadeau.get());
            return ResponseEntity.ok(dto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("cadeaux")
    public ResponseEntity<?> save(@RequestBody Cadeau cadeau) {
        if(cadeau.getNom() == null || cadeau.getNom().isBlank()) {
            return ResponseEntity.badRequest().body("Le nom du cadeau est obligatoire !");
        }
        else if(cadeau.getPrix() == null || cadeau.getPrix() <= 0) {
            return ResponseEntity.badRequest().body("Le prix du cadeau est obligatoire et sa valeur doit être positive !");
        }
        else {
            cadeauService.save(cadeau);
            return ResponseEntity.ok(cadeau);
        }
    }

    @DeleteMapping("cadeaux/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Optional<Cadeau> optionalCadeau = cadeauService.findById(id);

        if(optionalCadeau.isPresent()) {
            cadeauService.delete(optionalCadeau.get());
            return ResponseEntity.ok("Deleted successfully !");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
