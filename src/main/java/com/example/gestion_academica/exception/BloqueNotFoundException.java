package com.example.gestion_academica.exception;

public class BloqueNotFoundException extends RuntimeException{

    public BloqueNotFoundException(String mensaje) {
        super(mensaje);
    }
}
