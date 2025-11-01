package com.advancedgym.backend.socio.util;

import com.advancedgym.backend.socio.model.Socio;
import com.advancedgym.backend.socio.model.SocioDTO;
import org.springframework.stereotype.Component;

@Component // <-- Anotación clave para que Spring pueda inyectarlo en el servicio
public class SocioMapper {

    /**
     * Convierte una entidad Socio a un SocioDTO.
     * Se usa para enviar datos al exterior (al frontend).
     */
    public SocioDTO toDTO(Socio socio) {
        SocioDTO dto = new SocioDTO();
        dto.setDni(socio.getDni());
        dto.setNombre(socio.getNombre());
        dto.setApellidos(socio.getApellidos());
        dto.setTelefono(socio.getTelefono());
        dto.setEmail(socio.getEmail());
        // Convertimos el Enum a String para el DTO
        dto.setObjetivoFisico(socio.getObjetivoFisico().name());
        return dto;
    }

    /**
     * Convierte un SocioDTO a una entidad Socio.
     * Se usa para recibir datos del exterior y prepararlos para guardarlos.
     */
    public Socio toEntity(SocioDTO dto) {
        return Socio.builder()
                .dni(dto.getDni())
                .nombre(dto.getNombre())
                .apellidos(dto.getApellidos())
                .telefono(dto.getTelefono())
                .email(dto.getEmail())
                // Convertimos el String del DTO al Enum de la entidad
                .objetivoFisico(Socio.ObjetivoFisico.valueOf(dto.getObjetivoFisico()))
                // La contraseña no viene en el DTO, se gestionará en la capa de servicio
                .build();
    }
}