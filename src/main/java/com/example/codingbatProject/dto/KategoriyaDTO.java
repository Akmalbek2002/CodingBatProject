package com.example.codingbatProject.dto;

import lombok.Data;

import java.util.List;

@Data
public class KategoriyaDTO {
    private String kategoriyaNomi,izoh;
    private Integer yulduzchalarSoni;
    private List<Integer> integerList;
}
