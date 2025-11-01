package com.advancedgym.backend.monitor.controller;

import com.advancedgym.backend.monitor.model.MonitorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/monitores") // Define la URL base
public interface MonitorAPI {

    @PostMapping
    ResponseEntity<MonitorDTO> crearMonitor(@RequestBody MonitorDTO monitorDTO);

    @GetMapping
    ResponseEntity<List<MonitorDTO>> obtenerTodosLosMonitores();

    @GetMapping("/{id}")
    ResponseEntity<MonitorDTO> obtenerMonitorPorId(@PathVariable Long id);
}