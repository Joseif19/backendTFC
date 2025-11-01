package com.advancedgym.backend.reserva.controller.impl;

import com.advancedgym.backend.reserva.controller.ReservaAPI;
import com.advancedgym.backend.reserva.model.ReservaDTO;
import com.advancedgym.backend.reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // No olvides esta anotación
public class ReservaController implements ReservaAPI {

    @Autowired
    private ReservaService reservaService;

    @Override
    public ResponseEntity<ReservaDTO> crearReserva(ReservaDTO reservaDTO) {
        // Manejo de excepciones básico (en un proyecto real, se usa @ControllerAdvice)
        try {
            ReservaDTO reservaCreada = reservaService.crearReserva(reservaDTO);
            return new ResponseEntity<>(reservaCreada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Capturamos los errores de "Aforo completo" o "Reserva duplicada"
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<ReservaDTO>> obtenerTodasLasReservas() {
        List<ReservaDTO> reservas = reservaService.obtenerTodasLasReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReservaDTO> obtenerReservaPorId(Long id) {
        return reservaService.obtenerReservaPorId(id)
                .map(reservaDTO -> new ResponseEntity<>(reservaDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<List<ReservaDTO>> obtenerReservasPorSocio(String dni) {
        List<ReservaDTO> reservas = reservaService.obtenerReservasPorSocio(dni);
        if (reservas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }
}