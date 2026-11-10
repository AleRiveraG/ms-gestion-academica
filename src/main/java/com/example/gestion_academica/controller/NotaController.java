package com.example.gestion_academica.controller;

import com.example.gestion_academica.dto.NotaRequestDTO;
import com.example.gestion_academica.service.NotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/nota")
@RestController
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @GetMapping("/{idAlumno}")
    public ResponseEntity<?> listarNotasPorAlumno(@RequestParam Long idAlumno, @RequestParam Long idAsignatura) {
        List<Double> notas = notaService.notasPorAlumno(idAlumno, idAsignatura);
        return ResponseEntity.status(HttpStatus.OK).body(notas);
    }

    @PostMapping
    public ResponseEntity<?> registrarNota(@RequestBody @Valid NotaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.registrarNota(dto));
    }

    @GetMapping("/promedio")
    public ResponseEntity<?> calcularPromedio(@RequestParam Long idAlumno, @RequestParam Long idAsignatura) {
        return ResponseEntity.status(HttpStatus.OK).body(notaService.promedioNotasPorAlumno(idAlumno, idAsignatura));
    }
}