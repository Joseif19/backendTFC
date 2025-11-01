package com.advancedgym.backend.reserva.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // No muestra campos nulos
public class ReservaDTO {

    // Para SALIDA
    private Long id;
    private LocalDateTime fechaReserva;

    // Para ENTRADA (Creación)
    private String dniSocio;
    private Long idClase;

    // Para SALIDA (Visualización)
    private String nombreSocio;
    private String nombreClase;
    private LocalDateTime horarioClase;

}