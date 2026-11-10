package com.example.gestion_academica.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BloqueHorarioRequestDTO {

    @NotNull(message = "La hora de inicio no puede ser nula")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de termino no puede ser nula")
    private LocalTime horaTermino;
}
