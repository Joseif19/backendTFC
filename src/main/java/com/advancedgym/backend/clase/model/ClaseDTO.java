package com.advancedgym.backend.clase.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClaseDTO {

    private Long id;
    private String nombre;
    private LocalDateTime horario;
    private int duracion;
    private int aforoMaximo;

    // Para ENTRADA (Crear/Actualizar): Solo necesitamos el ID del monitor
    private Long monitorId;

    // Para SALIDA (Consultar): Enviamos el nombre del monitor para comodidad
    private String monitorNombre;
}