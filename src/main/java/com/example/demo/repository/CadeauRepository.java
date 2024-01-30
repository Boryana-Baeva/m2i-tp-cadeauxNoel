package com.example.demo.repository;

import com.example.demo.model.Cadeau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadeauRepository extends JpaRepository<Cadeau, Integer> {
}