package com.advancedgym.backend.pago.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagoDTO {

    private Long id;
    private LocalDate mes; // Ej: "2025-11-01"
    private String estado; // "PAGADO" o "NO_PAGADO"

    // Para ENTRADA (Crear)
    private String dniSocio;

    // Para SALIDA (Consultar)
    private String nombreSocio;
}