package com.example.codingbatProject.repository;

import com.example.codingbatProject.entity.Tillar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TillarRepository extends JpaRepository<Tillar,Integer> {
    Optional<Tillar> findByNomi(String nomi);
}
