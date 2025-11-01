package com.advancedgym.backend.socio.model; // O com.advancedgym.backend.socio.dto

import lombok.Data;

// El DTO solo contiene los campos que quieres exponer en tu API.
@Data
public class SocioDTO {
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    // ¡Fíjate que no incluimos la contraseña!
    private String objetivoFisico; // Lo manejaremos como String para simplicidad en la API
}