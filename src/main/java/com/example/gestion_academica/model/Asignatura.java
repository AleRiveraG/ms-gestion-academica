package com.example.gestion_academica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignatura")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 3)
    private Long idAsignatura;

    @Column(nullable = false, length = 50)
    private String nombre;
}
