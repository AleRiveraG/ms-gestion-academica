package com.example.gestion_academica.controller;

import com.example.gestion_academica.dto.HorarioRequestDTO;
import com.example.gestion_academica.service.HorarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horario")
@RequiredArgsConstructor
public class HorarioController {

    private final HorarioService horarioService;

    @GetMapping("/{idCurso}")
    public ResponseEntity<?> listarHorarioCurso(@PathVariable Long idCurso) {
        return ResponseEntity.status(HttpStatus.OK).body(horarioService.listarHorarioCurso(idCurso));
    }

    @PostMapping
    public ResponseEntity<?> registrarHorario(@RequestBody HorarioRequestDTO dto, @RequestParam Long idCurso, @RequestParam Long idAsignatura, @RequestParam Long idBloque) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioService.registrarHorario(dto, idCurso, idAsignatura, idBloque));
    }
}
