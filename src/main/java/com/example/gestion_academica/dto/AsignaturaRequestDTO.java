package com.example.gestion_academica.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AsignaturaRequestDTO {

    @NotBlank(message = "El nombre no puede ser nulo ni vacio")
    private String nombre;
}
