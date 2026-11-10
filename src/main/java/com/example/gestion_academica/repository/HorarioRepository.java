package com.example.gestion_academica.repository;

import com.example.gestion_academica.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    @Query("SELECT h FROM Horario h WHERE h.curso.idCurso = :idCurso")
    List<Horario> listarHorarioCurso(Long idCurso);
}
