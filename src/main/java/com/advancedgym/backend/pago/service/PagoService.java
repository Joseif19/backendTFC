package com.advancedgym.backend.pago.service;

import com.advancedgym.backend.pago.model.PagoDTO;

import java.util.List;
import java.util.Optional;

public interface PagoService {

    PagoDTO crearPago(PagoDTO pagoDTO);

    List<PagoDTO> obtenerPagosPorSocio(String dni);

    Optional<PagoDTO> obtenerPagoPorId(Long id);

    PagoDTO marcarComoPagado(Long id);
}