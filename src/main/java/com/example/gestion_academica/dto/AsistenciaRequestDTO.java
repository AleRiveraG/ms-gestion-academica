package com.example.gestion_academica.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaRequestDTO {

    @NotNull(message = "El id del alumno no puede ser nulo")
    private Long idAlumno;

    @NotNull(message = "El id de la asignatura no puede ser nulo")
    private Long idAsignatura;

    @NotNull(message = "Debe ser presente o ausente")
    private Boolean presente;

}
