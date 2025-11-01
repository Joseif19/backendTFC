package com.advancedgym.backend.pago.model;

import com.advancedgym.backend.socio.model.Socio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    @Column(name = "mes", nullable = false)
    private LocalDate mes; // Guardará 'YYYY-MM-01'

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoPago estado;

    // Relación "Muchos pagos pertenecen a Un socio"
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dni_socio", nullable = false)
    private Socio socio;

    public enum EstadoPago {
        PAGADO,
        NO_PAGADO
    }
}