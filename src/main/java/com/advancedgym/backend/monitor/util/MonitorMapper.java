package com.advancedgym.backend.monitor.util;

import com.advancedgym.backend.monitor.model.Especialidad;
import com.advancedgym.backend.monitor.model.Monitor;
import com.advancedgym.backend.monitor.model.MonitorDTO;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class MonitorMapper {

    /**
     * Convierte una entidad Monitor (de la BD) a un MonitorDTO (para el frontend).
     */
    public MonitorDTO toDTO(Monitor monitor) {
        MonitorDTO dto = new MonitorDTO();
        dto.setId(monitor.getId());
        dto.setNombre(monitor.getNombre());

        // Convertimos la lista de objetos Especialidad a una lista de Strings (nombres)
        if (monitor.getEspecialidades() != null) {
            dto.setEspecialidadNombres(monitor.getEspecialidades().stream()
                    .map(Especialidad::getNombre)
                    .collect(Collectors.toSet()));
        }
        return dto;
    }

    /**
     * Convierte un MonitorDTO (del frontend) a una entidad Monitor (para la BD).
     * Nota: Este mapper solo mapea los campos simples.
     * La lógica de IDs de especialidades se maneja en el Service.
     */
    public Monitor toEntity(MonitorDTO dto) {
        return Monitor.builder()
                .nombre(dto.getNombre())
                // El ID se genera automáticamente
                // Las especialidades se asignarán en la capa de servicio
                .build();
    }
}