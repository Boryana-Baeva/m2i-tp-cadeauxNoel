package com.example.demo;

import com.example.demo.model.Cadeau;
import com.example.demo.model.ListeCadeaux;
import com.example.demo.repository.CadeauRepository;
import com.example.demo.repository.ListeCadeauxRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JPARepositoryTest {
    @Autowired
    private CadeauRepository cadeauRepository;
    @Autowired
    private ListeCadeauxRepository listeCadeauxRepository;

    @Test
    void testSaveCadeau() {
        Cadeau cadeau1 = new Cadeau("Watch", "Brand : test", 205.00);
        cadeauRepository.save(cadeau1);

        Cadeau cadeau2 = new Cadeau("T-shirt", "Imprimée", 35.99);
        cadeauRepository.save(cadeau2);

        Cadeau cadeau3 = new Cadeau("Lipstick", "Color : Sugar Plum", 15.99);
        cadeauRepository.save(cadeau3);
    }

    @Test
    void testReadCadeau() {
        Optional<Cadeau> op = cadeauRepository.findById(1);
        op.ifPresent(System.out::println);
    }

    @Test
    void testReadAllCadeau() {
        List<Cadeau> cadeaux = cadeauRepository.findAll();
        cadeaux.forEach(System.out::println);
    }

    @Test
    void testSetListCadeau() {
        ListeCadeaux l1 = new ListeCadeaux("Family");
        listeCadeauxRepository.save(l1);
        ListeCadeaux l2 = new ListeCadeaux("Co-workers");
        listeCadeauxRepository.save(l2);
        ListeCadeaux l3 = new ListeCadeaux("Friends");
        listeCadeauxRepository.save(l3);

        List<Cadeau> cadeaux = cadeauRepository.findAll();

        cadeaux.get(0).setListeCadeaux(l1);
        cadeauRepository.save(cadeaux.get(0));
        cadeaux.get(1).setListeCadeaux(l2);
        cadeauRepository.save(cadeaux.get(1));
        cadeaux.get(2).setListeCadeaux(l3);
        cadeauRepository.save(cadeaux.get(2));


    }
}
