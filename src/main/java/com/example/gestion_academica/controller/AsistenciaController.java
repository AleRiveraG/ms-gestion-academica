package com.example.gestion_academica.controller;

import com.example.gestion_academica.dto.AsistenciaRequestDTO;
import com.example.gestion_academica.service.AsistenciaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencia")
@RequiredArgsConstructor
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    @GetMapping("/{idAlumno}")
    public ResponseEntity<?> consultarAsistencia(@PathVariable Long idAlumno) {

        return ResponseEntity.status(HttpStatus.OK).body(asistenciaService.consultaAsistencias(idAlumno));
    }

    @PostMapping
    public ResponseEntity<?> registrarAsistencia(@RequestBody @Valid AsistenciaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asistenciaService.registrarAsistencia(dto));

    }

}
