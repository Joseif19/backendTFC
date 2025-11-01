package com.advancedgym.backend.monitor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // No mostrará campos nulos en el JSON
public class MonitorDTO {

    private Long id;
    private String nombre;

    // Para ENTRADA (Crear/Actualizar): Pasamos los IDs de las especialidades
    private Set<Long> especialidadIds;

    // Para SALIDA (Consultar): Devolvemos los nombres de las especialidades
    private Set<String> especialidadNombres;
}