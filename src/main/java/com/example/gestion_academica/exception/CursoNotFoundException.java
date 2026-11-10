package com.example.gestion_academica.exception;

public class CursoNotFoundException extends RuntimeException{

    public CursoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
