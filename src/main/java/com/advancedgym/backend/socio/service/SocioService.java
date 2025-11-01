package com.advancedgym.backend.socio.service;

import com.advancedgym.backend.socio.model.SocioDTO;
import java.util.List;
import java.util.Optional;

public interface SocioService {
    SocioDTO crearSocio(SocioDTO socioDTO);
    List<SocioDTO> obtenerTodosLosSocios();
    Optional<SocioDTO> obtenerSocioPorDni(String dni);
    // Aquí añadirías más métodos de negocio en el futuro (ej: actualizarSocio, darDeBajaSocio, etc.)
}