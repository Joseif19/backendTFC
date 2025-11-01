package com.advancedgym.backend.monitor.controller;

import com.advancedgym.backend.monitor.model.Especialidad;
import com.advancedgym.backend.monitor.repository.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EspecialidadController implements EspecialidadAPI {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Override
    public ResponseEntity<Especialidad> crearEspecialidad(@RequestBody Especialidad especialidad) {
        Especialidad nueva = especialidadRepository.save(especialidad);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Especialidad>> obtenerEspecialidades() {
        return new ResponseEntity<>(especialidadRepository.findAll(), HttpStatus.OK);
    }
}