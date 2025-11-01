package com.advancedgym.backend.clase.repository;

import com.advancedgym.backend.clase.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
    // La clave primaria es 'Long'
}