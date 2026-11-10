package com.example.gestion_academica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequestDTO {

    @NotNull(message = "El grado no puede ser nulo")
    private int grado;


    @NotBlank(message = "El nivel no puede ser nulo ni vacio")
    private String nivel;
}
