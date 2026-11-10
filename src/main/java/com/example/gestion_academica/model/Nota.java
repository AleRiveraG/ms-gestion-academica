package com.example.gestion_academica.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nota")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 3)
    private Long idNota;

    @Column(nullable = false, length = 3)
    private Long idAlumno;

    @Column(nullable = false)
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "idAsignatura")
    private Asignatura asignatura;


}
