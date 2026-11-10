package com.example.gestion_academica.service;

import com.example.gestion_academica.dto.AsignaturaRequestDTO;
import com.example.gestion_academica.exception.AsignaturaNotFoundException;
import com.example.gestion_academica.model.Asignatura;
import com.example.gestion_academica.repository.AsignaturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public List<Asignatura> obtenerAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Asignatura registrarAsignatura(AsignaturaRequestDTO dto) {
        Asignatura asignatura = new Asignatura(null, dto.getNombre());
        asignaturaRepository.save(asignatura);
        return asignatura;
    }

    public Asignatura modificarAsignatura(AsignaturaRequestDTO dto, Long idAsignatura) {
        Optional<Asignatura> asignatura = asignaturaRepository.findById(idAsignatura);

        if(asignatura.isPresent()) {
            return asignatura.map(existente -> {
                existente.setNombre(dto.getNombre());

                return asignaturaRepository.save(existente);
            }).orElseThrow();
        }
        throw new AsignaturaNotFoundException("Asignatura no encontrada");

    }

    public void eliminarAsignatura(Long idAsignatura) {
        Optional<Asignatura> asignatura = asignaturaRepository.findById(idAsignatura);

        if(asignatura.isPresent()) {
            asignaturaRepository.deleteById(idAsignatura);
            return;
        }
    }


}
