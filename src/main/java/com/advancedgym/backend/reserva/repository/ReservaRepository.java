package com.advancedgym.backend.reserva.repository;

import com.advancedgym.backend.clase.model.Clase;
import com.advancedgym.backend.reserva.model.Reserva;
import com.advancedgym.backend.socio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Método para contar cuántas reservas tiene una clase (para el aforo)
    int countByClase(Clase clase);

    // Método para saber si un socio ya tiene reserva en una clase
    boolean existsBySocioAndClase(Socio socio, Clase clase);

    // Método para buscar todas las reservas de un socio
    List<Reserva> findBySocioDni(String dni);
}