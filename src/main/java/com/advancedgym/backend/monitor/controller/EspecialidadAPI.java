package com.advancedgym.backend.monitor.controller;

import com.advancedgym.backend.monitor.model.Especialidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/especialidades") // La URL base va en la interfaz
public interface EspecialidadAPI {

    @PostMapping
    ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad);

    @GetMapping
    ResponseEntity<List<Especialidad>> obtenerEspecialidades();
}