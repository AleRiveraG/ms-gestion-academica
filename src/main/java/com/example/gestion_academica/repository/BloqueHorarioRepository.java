package com.example.gestion_academica.repository;

import com.example.gestion_academica.model.BloqueHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueHorarioRepository extends JpaRepository<BloqueHorario, Long> {
}
