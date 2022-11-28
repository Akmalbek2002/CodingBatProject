package com.example.codingbatProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Savollar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String savolNomi;
    @Column(nullable = false)
    private String savolMatni;
    @Column(nullable = false)
    private String yechim;
    @Column(nullable = false)
    private String funksiya;
    @OneToOne
    Namuna namuna;
    @ManyToMany
    List<Kategoriya> kategoriyaList;

}
