package com.example.codingbatProject.dto;

import lombok.Data;

import java.util.List;

@Data
public class SavollarDTO {
    private String savolNomi,savolMatni,yechim,funksiya;
    private String namuna;
    private List<Integer> kategoriyaList;
}
