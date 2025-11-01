package com.advancedgym.backend.clase.controller;

import com.advancedgym.backend.clase.model.ClaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clases") // URL base
public interface ClaseAPI {

    @PostMapping
    ResponseEntity<ClaseDTO> crearClase(@RequestBody ClaseDTO claseDTO);

    @GetMapping
    ResponseEntity<List<ClaseDTO>> obtenerTodasLasClases();

    @GetMapping("/{id}")
    ResponseEntity<ClaseDTO> obtenerClasePorId(@PathVariable Long id);
}