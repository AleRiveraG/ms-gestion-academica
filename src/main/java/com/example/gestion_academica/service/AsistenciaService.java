package com.example.gestion_academica.service;

import com.example.gestion_academica.dto.AsistenciaRequestDTO;
import com.example.gestion_academica.model.Asignatura;
import com.example.gestion_academica.model.Asistencia;
import com.example.gestion_academica.repository.AsignaturaRepository;
import com.example.gestion_academica.repository.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final AsignaturaRepository asignaturaRepository;

    public Asistencia registrarAsistencia(AsistenciaRequestDTO dto) {
        Asignatura asignatura = asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow( () -> new RuntimeException("Asignatura no encontrada"));

        Asistencia asistencia = new Asistencia(null, dto.getIdAlumno(),dto.getPresente(), LocalDate.now(), asignatura);

        return asistenciaRepository.save(asistencia);
    }

    public Map<String, Object> consultaAsistencias(Long idAlumno) {
        List<Asistencia> asistencias = asistenciaRepository.buscarAsistencias(idAlumno);
        int contadorPresente = 0;
        int contadorAusente = 0;

        for(Asistencia asistencia : asistencias) {
            if(asistencia.getPresente()) {
                contadorPresente +=1;
            } else {
                contadorAusente +=1;
            }
        }

        Map<String,Object> datos = new HashMap<>();

        datos.put("Presente",contadorPresente);
        datos.put("Ausente", contadorAusente);

        return datos;
    }
}
