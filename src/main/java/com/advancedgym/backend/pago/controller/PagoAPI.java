package com.advancedgym.backend.pago.controller;

import com.advancedgym.backend.pago.model.PagoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pagos") // URL base
public interface PagoAPI {

    @PostMapping
    ResponseEntity<?> crearPago(@RequestBody PagoDTO pagoDTO);

    @GetMapping("/socio/{dni}")
    ResponseEntity<List<PagoDTO>> obtenerPagosPorSocio(@PathVariable String dni);

    @GetMapping("/{id}")
    ResponseEntity<PagoDTO> obtenerPagoPorId(@PathVariable Long id);

    @PutMapping("/{id}/pagar") // Endpoint específico para la acción de pagar
    ResponseEntity<PagoDTO> marcarComoPagado(@PathVariable Long id);
}