package com.advancedgym.backend.reserva.util;

import com.advancedgym.backend.reserva.model.Reserva;
import com.advancedgym.backend.reserva.model.ReservaDTO;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    /**
     * Convierte una entidad Reserva (de la BD) a un ReservaDTO (para el frontend).
     */
    public ReservaDTO toDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();
        dto.setId(reserva.getId());
        dto.setFechaReserva(reserva.getFechaReserva());

        // Rellenamos datos del Socio (si existe)
        if (reserva.getSocio() != null) {
            dto.setDniSocio(reserva.getSocio().getDni());
            dto.setNombreSocio(reserva.getSocio().getNombre() + " " + reserva.getSocio().getApellidos());
        }

        // Rellenamos datos de la Clase (si existe)
        if (reserva.getClase() != null) {
            dto.setIdClase(reserva.getClase().getId());
            dto.setNombreClase(reserva.getClase().getNombre());
            dto.setHorarioClase(reserva.getClase().getHorario());
        }

        return dto;
    }

    /**
     * Crea una entidad Reserva vacía.
     * La lógica de asignación se hace en la capa de Servicio.
     */
    public Reserva toEntity(ReservaDTO dto) {
        // El DTO de entrada solo tiene IDs, la lógica de negocio la tiene el servicio
        return Reserva.builder()
                .build();
    }
}