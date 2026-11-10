package com.example.gestion_academica.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioRequestDTO {

    @NotBlank(message = "El dia no puede ser vacio ni nulo")
    private String dia;
}
