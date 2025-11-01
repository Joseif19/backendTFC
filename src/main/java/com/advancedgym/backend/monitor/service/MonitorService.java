package com.advancedgym.backend.monitor.service;

import com.advancedgym.backend.monitor.model.MonitorDTO;
import java.util.List;
import java.util.Optional;

public interface MonitorService {

    MonitorDTO crearMonitor(MonitorDTO monitorDTO);

    List<MonitorDTO> obtenerTodosLosMonitores();

    Optional<MonitorDTO> obtenerMonitorPorId(Long id);

    // (Aquí irían los métodos de actualizar y borrar)
}