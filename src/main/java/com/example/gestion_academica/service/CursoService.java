package com.example.gestion_academica.service;

import com.example.gestion_academica.dto.CursoRequestDTO;
import com.example.gestion_academica.dto.CursoResponseDTO;
import com.example.gestion_academica.exception.CursoNotFoundException;
import com.example.gestion_academica.model.Curso;
import com.example.gestion_academica.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    private CursoResponseDTO mapToDTO(Curso curso) {
        return new CursoResponseDTO(
                curso.getGrado(),
                curso.getNivel()
        );
    }

    public List<CursoResponseDTO> listarCursos(){
        return cursoRepository.findAll()
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CursoResponseDTO registrarCurso(CursoRequestDTO dto) {

        Curso curso = new Curso(null, dto.getGrado(), dto.getNivel());

        return mapToDTO(cursoRepository.save((curso)));
    }

    public CursoResponseDTO modificarCurso(Long idCurso, CursoRequestDTO dto) {
        Optional<Curso> curso = cursoRepository.findById(idCurso);

        if(curso.isPresent()) {
            return curso.map(existente -> {
                existente.setGrado(dto.getGrado());
                existente.setNivel(dto.getNivel());

                return mapToDTO(cursoRepository.save(existente));
            }).orElseThrow();
        }
        throw new CursoNotFoundException("Curso no encontrado.");
    }

    public void eliminarCurso(Long idCurso){
        Optional<Curso> curso = cursoRepository.findById(idCurso);

        if(curso.isPresent()) {
            cursoRepository.deleteById(idCurso);
            return;
        }
        return;
    }
}
