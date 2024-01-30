package com.example.demo.repository;

import com.example.demo.model.ListeCadeaux;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListeCadeauxRepository extends JpaRepository<ListeCadeaux, Integer> {
}