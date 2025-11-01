package com.advancedgym.backend.pago.controller.impl;

import com.advancedgym.backend.pago.controller.PagoAPI;
import com.advancedgym.backend.pago.model.PagoDTO;
import com.advancedgym.backend.pago.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // No olvides esta anotación
public class PagoController implements PagoAPI {

    @Autowired
    private PagoService pagoService;

    @Override
    public ResponseEntity<?> crearPago(PagoDTO pagoDTO) {
        try {
            PagoDTO pagoCreado = pagoService.crearPago(pagoDTO);
            return new ResponseEntity<>(pagoCreado, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Captura el error de "Socio no encontrado" o "Pago duplicado"
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<PagoDTO>> obtenerPagosPorSocio(String dni) {
        List<PagoDTO> pagos = pagoService.obtenerPagosPorSocio(dni);
        if (pagos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PagoDTO> obtenerPagoPorId(Long id) {
        return pagoService.obtenerPagoPorId(id)
                .map(pagoDTO -> new ResponseEntity<>(pagoDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<PagoDTO> marcarComoPagado(Long id) {
        try {
            PagoDTO pagoActualizado = pagoService.marcarComoPagado(id);
            return new ResponseEntity<>(pagoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si no se encontró el pago
        }
    }
}