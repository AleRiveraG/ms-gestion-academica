package com.example.gestion_academica.exception;

public class AsignaturaNotFoundException extends RuntimeException{

    public AsignaturaNotFoundException(String mensaje) {
        super(mensaje);
    }
}
