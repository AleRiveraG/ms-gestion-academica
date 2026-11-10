package com.example.gestion_academica.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 3)
    private Long idCurso;

    @Column(nullable = false, length = 2)
    private int grado;

    @Column(nullable = false, length = 10)
    private String nivel;
}
