package com.example.gestion_academica.controller;

import com.example.gestion_academica.dto.BloqueHorarioRequestDTO;
import com.example.gestion_academica.service.BloqueHorarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloque")
@RequiredArgsConstructor
public class BloqueHorarioController {

    private final BloqueHorarioService bloqueHorarioService;

    @GetMapping
    public ResponseEntity<?> listarTodo(){
        return ResponseEntity.status(HttpStatus.OK).body(bloqueHorarioService.listarBloques());
    }

    @PostMapping
    public ResponseEntity<?> registrarBloque(@RequestBody @Valid BloqueHorarioRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bloqueHorarioService.registrarBloque(dto));
    }
}
