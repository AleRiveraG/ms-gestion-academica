package com.example.gestion_academica.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaResponseDTO {

    private List<Double> notas;

    private Double promedio;
}
