package com.example.codingbatProject.repository;

import com.example.codingbatProject.entity.Savollar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Savollar_Repository extends JpaRepository<Savollar,Integer> {
    Optional<Savollar> findBySavolNomiAndSavolMatni(String nom,String matn);
}
