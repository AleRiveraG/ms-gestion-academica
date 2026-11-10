package com.example.gestion_academica.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "horario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 3)
    private Long idHorario;

    @Column(nullable = false, length = 15)
    private String dia;

    @ManyToOne
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idAsignatura")
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "idBloqueHorario")
    private BloqueHorario bloqueHorario;

}
