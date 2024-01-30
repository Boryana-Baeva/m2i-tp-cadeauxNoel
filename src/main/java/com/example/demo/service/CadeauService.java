package com.example.demo.service;

import com.example.demo.model.Cadeau;
import com.example.demo.repository.CadeauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadeauService {
    @Autowired
    private CadeauRepository cadeauRepository;

    public void save(Cadeau cadeau) {
        cadeauRepository.save(cadeau);
    }

    public Optional<Cadeau> findById(Integer id) {
        return cadeauRepository.findById(id);
    }

    public List<Cadeau> findAll() {
        return cadeauRepository.findAll();
    }

    public void delete(Cadeau cadeau) {
        cadeauRepository.delete(cadeau);
    }

    public void update(Cadeau cadeau) {
        cadeauRepository.save(cadeau);
    }
}
