package com.advancedgym.backend.socio.repository;

import com.advancedgym.backend.socio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, String> {
    // ¡Y ya está!
    // Spring Data JPA creará automáticamente los métodos:
    // save(), findById(), findAll(), deleteById(), etc.
    // El primer parámetro 'Socio' es la entidad que gestiona.
    // El segundo 'String' es el tipo de la clave primaria (el DNI).
}