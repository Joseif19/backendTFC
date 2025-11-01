package com.advancedgym.backend.pago.repository;

import com.advancedgym.backend.pago.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    // Método para buscar todos los pagos de un socio por su DNI
    List<Pago> findBySocioDni(String dni);

    // Método para comprobar si ya existe un pago para ese socio en ese mes
    boolean existsBySocioDniAndMes(String dni, LocalDate mes);
}