package com.advancedgym.backend.monitor.repository;

import com.advancedgym.backend.monitor.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    // La clave primaria es 'Long', no 'String'
}