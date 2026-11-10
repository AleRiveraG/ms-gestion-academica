package com.example.gestion_academica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AsignaturaNotFoundException.class)
    public ResponseEntity<?> manejoAsignaturaNoEncontrada(AsignaturaNotFoundException e) {
        HashMap<String, Object> error = new HashMap<>();
        error.put("Estado", 404);
        error.put("Mensaje", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BloqueNotFoundException.class)
    public ResponseEntity<?> manejoBloqueNotFound(BloqueNotFoundException e) {
        HashMap<String, Object> error = new HashMap<>();
        error.put("Estado", 404);
        error.put("Mensaje", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CursoNotFoundException.class)
    public ResponseEntity<?> manejoCursoNotFound(CursoNotFoundException e) {
        HashMap<String, Object> error = new HashMap<>();
        error.put("Estado", 404);
        error.put("Mensaje", e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> manejoExcepciones(Exception e){
        HashMap<String, Object> error = new HashMap<>();
        error.put("Estado", 500);
        error.put("Mensaje", "Ups! Error interno en el servidor");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
