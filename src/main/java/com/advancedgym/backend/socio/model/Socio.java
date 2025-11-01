package com.advancedgym.backend.socio.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "socio")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Socio implements Serializable {

    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Column(name = "contraseña", nullable = false, length = 50)
    private String contraseña;

    @Enumerated(EnumType.STRING)
    @Column(name = "objetivo_fisico", nullable = false)
    private ObjetivoFisico objetivoFisico;

    public enum ObjetivoFisico {
        BAJAR_PESO,
        AUMENTAR_MASA,
        MANTENERSE,
        RECOMPOSICION
    }
}