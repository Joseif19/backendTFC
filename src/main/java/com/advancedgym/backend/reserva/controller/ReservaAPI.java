package com.advancedgym.backend.reserva.controller;

import com.advancedgym.backend.reserva.model.ReservaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/reservas") // URL base
public interface ReservaAPI {

    @PostMapping
    ResponseEntity<ReservaDTO> crearReserva(@RequestBody ReservaDTO reservaDTO);

    @GetMapping
    ResponseEntity<List<ReservaDTO>> obtenerTodasLasReservas();

    @GetMapping("/{id}")
    ResponseEntity<ReservaDTO> obtenerReservaPorId(@PathVariable Long id);

    @GetMapping("/socio/{dni}") // Endpoint para buscar por DNI
    ResponseEntity<List<ReservaDTO>> obtenerReservasPorSocio(@PathVariable String dni);
}