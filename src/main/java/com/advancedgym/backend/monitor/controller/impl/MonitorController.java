package com.advancedgym.backend.monitor.controller.impl;

import com.advancedgym.backend.monitor.controller.MonitorAPI;
import com.advancedgym.backend.monitor.model.MonitorDTO;
import com.advancedgym.backend.monitor.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // No olvides esta anotación
public class MonitorController implements MonitorAPI {

    @Autowired
    private MonitorService monitorService;

    @Override
    public ResponseEntity<MonitorDTO> crearMonitor(MonitorDTO monitorDTO) {
        MonitorDTO monitorCreado = monitorService.crearMonitor(monitorDTO);
        return new ResponseEntity<>(monitorCreado, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<MonitorDTO>> obtenerTodosLosMonitores() {
        List<MonitorDTO> monitores = monitorService.obtenerTodosLosMonitores();
        return new ResponseEntity<>(monitores, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MonitorDTO> obtenerMonitorPorId(Long id) {
        return monitorService.obtenerMonitorPorId(id)
                .map(monitorDTO -> new ResponseEntity<>(monitorDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}