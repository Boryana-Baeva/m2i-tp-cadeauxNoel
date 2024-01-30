package com.example.demo;

import com.example.demo.model.Cadeau;
import com.example.demo.repository.CadeauRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class JPARepositoryTest {
    @Autowired
    private CadeauRepository cadeauRepository;

    @Test
    void testSaveCadeau() {
//        Cadeau cadeau1 = new Cadeau("Watch", "Brand : test", 205.00);
//        cadeauRepository.save(cadeau1);

        Cadeau cadeau2 = new Cadeau("T-shirt", "Imprimée", 35.99);
        cadeauRepository.save(cadeau2);
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
}
