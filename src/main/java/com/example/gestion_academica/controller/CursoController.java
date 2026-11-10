package com.example.gestion_academica.controller;

import com.example.gestion_academica.dto.CursoRequestDTO;
import com.example.gestion_academica.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<?> listarCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarCursos());
    }

    @PostMapping
    public ResponseEntity<?> registrarCurso(@RequestBody @Valid CursoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.registrarCurso(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modificarCurso(@PathVariable Long idCurso, @RequestBody @Valid CursoRequestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.modificarCurso(idCurso, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Long idCurso) {
        cursoService.eliminarCurso(idCurso);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
