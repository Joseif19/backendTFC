package com.advancedgym.backend.pago.util;

import com.advancedgym.backend.pago.model.Pago;
import com.advancedgym.backend.pago.model.PagoDTO;
import org.springframework.stereotype.Component;

@Component
public class PagoMapper {

    /**
     * Convierte una entidad Pago (de la BD) a un PagoDTO (para el frontend).
     */
    public PagoDTO toDTO(Pago pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setMes(pago.getMes());
        dto.setEstado(pago.getEstado().name()); // Convierte Enum a String
        dto.setDniSocio(pago.getSocio().getDni());
        dto.setNombreSocio(pago.getSocio().getNombre() + " " + pago.getSocio().getApellidos());
        return dto;
    }

    /**
     * Convierte un PagoDTO (del frontend) a una entidad Pago (para la BD).
     * Los campos 'socio' y 'estado' se asignan en el servicio.
     */
    public Pago toEntity(PagoDTO dto) {
        return Pago.builder()
                .mes(dto.getMes())
                .build();
    }
}