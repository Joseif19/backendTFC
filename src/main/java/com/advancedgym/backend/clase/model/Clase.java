package com.advancedgym.backend.clase.model;

import com.advancedgym.backend.monitor.model.Monitor; // <-- Importa el Monitor
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "clase")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Clase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "horario", nullable = false)
    private LocalDateTime horario; // Para guardar fecha Y hora

    @Column(name = "duracion", nullable = false)
    private int duracion; // Duración en minutos

    @Column(name = "aforo_maximo", nullable = false)
    private int aforoMaximo;

    // Relación "Muchas clases pueden ser impartidas por Un monitor"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_monitor", nullable = false) // La columna FK
    private Monitor monitor;
}