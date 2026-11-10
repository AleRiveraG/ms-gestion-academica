package com.example.gestion_academica.service;

import com.example.gestion_academica.dto.BloqueHorarioRequestDTO;
import com.example.gestion_academica.model.BloqueHorario;
import com.example.gestion_academica.repository.BloqueHorarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloqueHorarioService {

    private final BloqueHorarioRepository bloqueHorarioRepository;

    public BloqueHorario registrarBloque(BloqueHorarioRequestDTO dto) {

        BloqueHorario bloque = new BloqueHorario(null, dto.getHoraInicio(), dto.getHoraTermino());

        return bloqueHorarioRepository.save(bloque);

    }

    public void eliminarBloque(Long idBloque) {
        bloqueHorarioRepository.deleteById(idBloque);
    }

    public List<BloqueHorario> listarBloques(){
        return bloqueHorarioRepository.findAll();
    }
}
