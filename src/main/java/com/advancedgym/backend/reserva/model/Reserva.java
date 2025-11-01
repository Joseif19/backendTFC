package com.advancedgym.backend.reserva.model;

import com.advancedgym.backend.clase.model.Clase;
import com.advancedgym.backend.socio.model.Socio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva",
        // Añadimos la restricción de unicidad que definimos en la BBDD
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"dni_socio", "id_clase"})
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDateTime fechaReserva;

    // Relación "Muchas reservas pueden ser de Un socio"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dni_socio", nullable = false)
    private Socio socio;

    // Relación "Muchas reservas pueden ser para Una clase"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clase", nullable = false)
    private Clase clase;
}