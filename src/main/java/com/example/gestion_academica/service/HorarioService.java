package com.example.gestion_academica.service;

import com.example.gestion_academica.dto.HorarioRequestDTO;
import com.example.gestion_academica.dto.HorarioResponseDTO;
import com.example.gestion_academica.exception.AsignaturaNotFoundException;
import com.example.gestion_academica.exception.BloqueNotFoundException;
import com.example.gestion_academica.exception.CursoNotFoundException;
import com.example.gestion_academica.model.Asignatura;
import com.example.gestion_academica.model.BloqueHorario;
import com.example.gestion_academica.model.Curso;
import com.example.gestion_academica.model.Horario;
import com.example.gestion_academica.repository.AsignaturaRepository;
import com.example.gestion_academica.repository.BloqueHorarioRepository;
import com.example.gestion_academica.repository.CursoRepository;
import com.example.gestion_academica.repository.HorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HorarioService {

    private final HorarioRepository horarioRepository;
    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final BloqueHorarioRepository bloqueHorarioRepository;

    public HorarioResponseDTO mapToDTO(Horario horario) {
        return new HorarioResponseDTO(
                horario.getDia(),
                horario.getCurso().getGrado() + "-" + horario.getCurso().getNivel(),
                horario.getAsignatura().getNombre(),
                horario.getBloqueHorario().getHoraInicio(),
                horario.getBloqueHorario().getHoraFin()
        );
    }

    public HorarioResponseDTO registrarHorario(HorarioRequestDTO dto, Long idCurso, Long idAsignatura, Long idBloque) {

        Curso curso = cursoRepository.findById(idCurso)
                .orElseThrow( () -> new CursoNotFoundException("Curso no encontrado"));

        Asignatura asignatura = asignaturaRepository.findById(idAsignatura)
                .orElseThrow( () -> new AsignaturaNotFoundException("Asignatura no encontrada"));

        BloqueHorario bloque = bloqueHorarioRepository.findById(idBloque)
                .orElseThrow( () -> new BloqueNotFoundException("Bloque no encontrado"));

        Horario horario = new Horario(null, dto.getDia(), curso, asignatura, bloque);

        return mapToDTO(horarioRepository.save(horario));

    }

    public List<HorarioResponseDTO> listarHorarioCurso(Long idCurso) {
        return horarioRepository.listarHorarioCurso(idCurso)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

}
