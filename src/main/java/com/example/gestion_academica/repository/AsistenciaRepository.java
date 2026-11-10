package com.example.gestion_academica.repository;

import com.example.gestion_academica.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {

    @Query("SELECT a FROM Asistencia a WHERE a.idAlumno = :idAlumno")
    List<Asistencia> buscarAsistencias(Long idAlumno);
}
