package com.example.gestion_academica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaRequestDTO {

    @NotNull(message = "La nota no puede ser nula")
    private Double nota;

    @NotNull(message = "El id del alumno no puede ser nulo")
    private Long idAlumno;

    @NotNull(message = "El id de la asignatura no puede ser nula")
    private Long idAsignatura;

}
