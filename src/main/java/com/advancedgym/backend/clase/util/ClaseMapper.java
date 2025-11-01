package com.advancedgym.backend.clase.util;

import com.advancedgym.backend.clase.model.Clase;
import com.advancedgym.backend.clase.model.ClaseDTO;
import org.springframework.stereotype.Component;

@Component
public class ClaseMapper {

    /**
     * Convierte una entidad Clase (de la BD) a un ClaseDTO (para el frontend).
     */
    public ClaseDTO toDTO(Clase clase) {
        ClaseDTO dto = new ClaseDTO();
        dto.setId(clase.getId());
        dto.setNombre(clase.getNombre());
        dto.setHorario(clase.getHorario());
        dto.setDuracion(clase.getDuracion());
        dto.setAforoMaximo(clase.getAforoMaximo());

        // Asignamos los datos del monitor si no es nulo
        if (clase.getMonitor() != null) {
            dto.setMonitorId(clase.getMonitor().getId());
            dto.setMonitorNombre(clase.getMonitor().getNombre());
        }
        return dto;
    }

    /**
     * Convierte un ClaseDTO (del frontend) a una entidad Clase (para la BD).
     * Nota: La asignación del objeto Monitor se hace en la capa de Servicio.
     */
    public Clase toEntity(ClaseDTO dto) {
        return Clase.builder()
                .nombre(dto.getNombre())
                .horario(dto.getHorario())
                .duracion(dto.getDuracion())
                .aforoMaximo(dto.getAforoMaximo())
                // El monitor se asigna en el servicio usando el monitorId
                .build();
    }
}