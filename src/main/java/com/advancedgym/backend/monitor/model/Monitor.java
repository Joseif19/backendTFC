package com.advancedgym.backend.monitor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "monitor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usamos ID autoincremental
    @Column(name = "id_monitor")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // Relación Muchos a Muchos con Especialidad
    @ManyToMany(fetch = FetchType.LAZY) // LAZY es más eficiente
    @JoinTable(
            name = "monitor_especialidad", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "id_monitor"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad")
    )
    private Set<Especialidad> especialidades;
}