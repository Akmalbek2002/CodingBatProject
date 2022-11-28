package com.example.codingbatProject.entity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Kategoriya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String kategoriyaNomi;
    @Column(nullable = false)
    private String izoh;
    @Column(nullable = false)
    private Integer yulduzchalarSoni;
    @ManyToMany
    List<Tillar> list;
}
