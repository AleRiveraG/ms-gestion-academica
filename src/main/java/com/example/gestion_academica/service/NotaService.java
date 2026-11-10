package com.example.gestion_academica.service;


import com.example.gestion_academica.dto.NotaRequestDTO;
import com.example.gestion_academica.exception.AsignaturaNotFoundException;
import com.example.gestion_academica.model.Asignatura;
import com.example.gestion_academica.model.Nota;
import com.example.gestion_academica.repository.AsignaturaRepository;
import com.example.gestion_academica.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final AsignaturaRepository asignaturaRepository;

    public Nota registrarNota(NotaRequestDTO dto) {

        Asignatura asignatura = asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow( () -> new AsignaturaNotFoundException("Asignatura no encontrada"));

        Nota nota = new Nota(null, dto.getIdAlumno(),dto.getNota(), asignatura);
        //Falta validacion de que el alumno exista
        return notaRepository.save(nota);
    }

    public List<Double> notasPorAlumno(Long alumnoId, Long idAsignatura) {
        return notaRepository.buscarNotasPorAlumno(alumnoId, idAsignatura);
    }

    public Double promedioNotasPorAlumno(Long alumnoId, Long idAsignatura) {
        List<Double> notas = notaRepository.buscarNotasPorAlumno(alumnoId, idAsignatura);

        if(notas.isEmpty()) {
            return 0.0;
        }

        Double suma = notas.stream().mapToDouble(Double::doubleValue).sum();

        return suma/notas.size();
    }
}
