package com.example.gestion_academica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "asistencia")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 3)
    private Long idAsistencia;

    @Column(nullable = false, length = 3)
    private Long idAlumno;

    @Column(nullable = false)
    private Boolean presente;

    @Column(nullable = false)
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idAsignatura")
    private Asignatura asignatura;

}
