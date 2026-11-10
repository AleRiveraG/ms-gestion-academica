package com.example.gestion_academica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HorarioResponseDTO {

    private String dia;
    private String curso;
    private String asignatura;
    private LocalTime horaInicio;
    private LocalTime horaTermino;
}
