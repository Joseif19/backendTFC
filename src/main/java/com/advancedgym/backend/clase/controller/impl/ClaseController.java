package com.advancedgym.backend.clase.controller.impl;

import com.advancedgym.backend.clase.controller.ClaseAPI;
import com.advancedgym.backend.clase.model.ClaseDTO;
import com.advancedgym.backend.clase.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // No olvides esta anotación
public class ClaseController implements ClaseAPI {

    @Autowired
    private ClaseService claseService;

    @Override
    public ResponseEntity<ClaseDTO> crearClase(ClaseDTO claseDTO) {
        ClaseDTO claseCreada = claseService.crearClase(claseDTO);
        return new ResponseEntity<>(claseCreada, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ClaseDTO>> obtenerTodasLasClases() {
        List<ClaseDTO> clases = claseService.obtenerTodasLasClases();
        return new ResponseEntity<>(clases, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ClaseDTO> obtenerClasePorId(Long id) {
        return claseService.obtenerClasePorId(id)
                .map(claseDTO -> new ResponseEntity<>(claseDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}