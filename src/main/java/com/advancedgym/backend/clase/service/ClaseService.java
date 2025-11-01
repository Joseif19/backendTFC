package com.advancedgym.backend.clase.service;

import com.advancedgym.backend.clase.model.ClaseDTO;

import java.util.List;
import java.util.Optional;

public interface ClaseService {

    ClaseDTO crearClase(ClaseDTO claseDTO);

    List<ClaseDTO> obtenerTodasLasClases();

    Optional<ClaseDTO> obtenerClasePorId(Long id);
}