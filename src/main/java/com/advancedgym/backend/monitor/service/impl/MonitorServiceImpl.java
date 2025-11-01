package com.advancedgym.backend.monitor.service.impl;

import com.advancedgym.backend.monitor.model.Especialidad;
import com.advancedgym.backend.monitor.model.Monitor;
import com.advancedgym.backend.monitor.model.MonitorDTO;
import com.advancedgym.backend.monitor.repository.MonitorRepository;
import com.advancedgym.backend.monitor.service.MonitorService;
import com.advancedgym.backend.monitor.util.MonitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private MonitorRepository monitorRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository; // Necesario para las especialidades

    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public MonitorDTO crearMonitor(MonitorDTO monitorDTO) {
        // 1. Convertimos DTO a Entidad (solo campos simples)
        Monitor monitor = monitorMapper.toEntity(monitorDTO);

        // 2. Lógica de negocio: Asignar especialidades
        if (monitorDTO.getEspecialidadIds() != null && !monitorDTO.getEspecialidadIds().isEmpty()) {
            Set<Especialidad> especialidades = new HashSet<>(
                    especialidadRepository.findAllById(monitorDTO.getEspecialidadIds())
            );
            monitor.setEspecialidades(especialidades);
        }

        // 3. Guardamos la entidad completa
        Monitor monitorGuardado = monitorRepository.save(monitor);

        // 4. Devolvemos el DTO completo
        return monitorMapper.toDTO(monitorGuardado);
    }

    @Override
    public List<MonitorDTO> obtenerTodosLosMonitores() {
        return monitorRepository.findAll()
                .stream()
                .map(monitorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<MonitorDTO> obtenerMonitorPorId(Long id) {
        return monitorRepository.findById(id)
                .map(monitorMapper::toDTO);
    }
}