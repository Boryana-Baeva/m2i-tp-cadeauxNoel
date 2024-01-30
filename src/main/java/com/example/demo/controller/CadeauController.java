package com.example.demo.controller;

import com.example.demo.model.Cadeau;
import com.example.demo.model.ListeCadeaux;
import com.example.demo.service.CadeauService;
import com.example.demo.service.ListeCadeauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class CadeauController {
    @Autowired
    private CadeauService cadeauService;
    @Autowired
    private ListeCadeauxService listeCadeauxService;


    @GetMapping("cadeaux")
    public List<CadeauDTO> getAll() {
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
    public ResponseEntity<?> save(@RequestBody CadeauDTO dto) {
        if(dto.getNom() == null || dto.getNom().isBlank()) {
            return ResponseEntity.badRequest().body("Le nom du cadeau est obligatoire !");
        }
        else if(dto.getPrix() == null || dto.getPrix().isBlank()) {
            return ResponseEntity.badRequest().body("Le prix du cadeau est obligatoire et sa valeur doit être positive !");
        }
        else {
            Cadeau cadeau = CadeauMapper.convertToEntity(dto);

            if(dto.getListe() != null && !dto.getListe().isBlank()) {
                ListeCadeaux listeCadeaux = listeCadeauxService.findByNom(dto.getListe());
                cadeau.setListeCadeaux(listeCadeaux);
            }

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
