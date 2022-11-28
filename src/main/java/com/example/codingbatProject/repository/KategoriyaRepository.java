package com.example.codingbatProject.repository;

import com.example.codingbatProject.entity.Kategoriya;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KategoriyaRepository extends JpaRepository<Kategoriya,Integer> {
    Optional<Kategoriya> findByKategoriyaNomi(String nomi);
}
