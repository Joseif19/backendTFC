package com.advancedgym.backend.reserva.service;

import com.advancedgym.backend.reserva.model.ReservaDTO;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    ReservaDTO crearReserva(ReservaDTO reservaDTO);

    List<ReservaDTO> obtenerTodasLasReservas();

    Optional<ReservaDTO> obtenerReservaPorId(Long id);

    List<ReservaDTO> obtenerReservasPorSocio(String dni);
}