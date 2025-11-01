package com.advancedgym.backend.clase.service.impl;

import com.advancedgym.backend.clase.model.Clase;
import com.advancedgym.backend.clase.model.ClaseDTO;
import com.advancedgym.backend.clase.repository.ClaseRepository;
import com.advancedgym.backend.clase.service.ClaseService;
import com.advancedgym.backend.clase.util.ClaseMapper;
import com.advancedgym.backend.monitor.model.Monitor;
import com.advancedgym.backend.monitor.repository.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private MonitorRepository monitorRepository; // Para buscar el monitor

    @Autowired
    private ClaseMapper claseMapper;

    @Override
    public ClaseDTO crearClase(ClaseDTO claseDTO) {
        // 1. Convertimos DTO a Entidad (campos simples)
        Clase clase = claseMapper.toEntity(claseDTO);

        // 2. Lógica de negocio: Buscar y asignar el Monitor
        Monitor monitor = monitorRepository.findById(claseDTO.getMonitorId())
                .orElseThrow(() -> new RuntimeException("Monitor no encontrado con id: " + claseDTO.getMonitorId()));

        clase.setMonitor(monitor);

        // 3. Guardamos la entidad completa
        Clase claseGuardada = claseRepository.save(clase);

        // 4. Devolvemos el DTO completo
        return claseMapper.toDTO(claseGuardada);
    }

    @Override
    public List<ClaseDTO> obtenerTodasLasClases() {
        return claseRepository.findAll()
                .stream()
                .map(claseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClaseDTO> obtenerClasePorId(Long id) {
        return claseRepository.findById(id)
                .map(claseMapper::toDTO);
    }
}