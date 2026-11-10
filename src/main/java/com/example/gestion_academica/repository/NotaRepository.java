package com.example.gestion_academica.repository;

import com.example.gestion_academica.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT n.nota FROM Nota n WHERE n.idAlumno = :alumnoId AND n.asignatura.idAsignatura = :idAsignatura")
    List<Double> buscarNotasPorAlumno(Long alumnoId, Long idAsignatura);
}


