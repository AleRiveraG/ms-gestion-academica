package com.example.gestion_academica.controller;

import com.example.gestion_academica.dto.AsignaturaRequestDTO;
import com.example.gestion_academica.service.AsignaturaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asignatura")
@RequiredArgsConstructor
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    @GetMapping
    public ResponseEntity<?> listarAsignaturas() {
        return ResponseEntity.status(HttpStatus.OK).body(asignaturaService.obtenerAsignaturas());
    }

    @PostMapping
    public ResponseEntity<?> registrarAsignatura(@RequestBody @Valid AsignaturaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.registrarAsignatura(dto));
    }

    @PatchMapping("/{idAsignatura}")
    public ResponseEntity<?> modificarAsignatura(@PathVariable Long idAsignatura, @RequestBody @Valid AsignaturaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.modificarAsignatura(dto, idAsignatura));
    }

    @DeleteMapping("/{idAsignatura}")
    public ResponseEntity<?> eliminarAsignatura(@PathVariable Long idAsignatura) {
        asignaturaService.eliminarAsignatura(idAsignatura);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}