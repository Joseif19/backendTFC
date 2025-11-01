package com.advancedgym.backend.socio.controller;

import com.advancedgym.backend.socio.model.SocioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SocioAPI {

    @PostMapping
    ResponseEntity<SocioDTO> crearSocio(@RequestBody SocioDTO socioDTO);

    @GetMapping
    ResponseEntity<List<SocioDTO>> obtenerTodosLosSocios();

    @GetMapping("/{dni}")
    ResponseEntity<SocioDTO> obtenerSocioPorDni(@PathVariable String dni);
}