package com.advancedgym.backend.reserva.service.impl;

import com.advancedgym.backend.clase.model.Clase;
import com.advancedgym.backend.clase.repository.ClaseRepository;
import com.advancedgym.backend.reserva.model.Reserva;
import com.advancedgym.backend.reserva.model.ReservaDTO;
import com.advancedgym.backend.reserva.repository.ReservaRepository;
import com.advancedgym.backend.reserva.service.ReservaService;
import com.advancedgym.backend.reserva.util.ReservaMapper;
import com.advancedgym.backend.socio.model.Socio;
import com.advancedgym.backend.socio.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    @Override
    public ReservaDTO crearReserva(ReservaDTO reservaDTO) {
        // 1. Buscar las entidades principales
        Socio socio = socioRepository.findById(reservaDTO.getDniSocio())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        Clase clase = claseRepository.findById(reservaDTO.getIdClase())
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        // 2. Lógica de Negocio: Comprobar duplicados
        if (reservaRepository.existsBySocioAndClase(socio, clase)) {
            throw new RuntimeException("Ya tienes una reserva para esta clase");
        }

        // 3. Lógica de Negocio: Comprobar aforo
        int reservasActuales = reservaRepository.countByClase(clase);
        if (reservasActuales >= clase.getAforoMaximo()) {
            throw new RuntimeException("Aforo completo para esta clase");
        }

        // 4. Crear la entidad
        Reserva nuevaReserva = reservaMapper.toEntity(reservaDTO);
        nuevaReserva.setSocio(socio);
        nuevaReserva.setClase(clase);
        nuevaReserva.setFechaReserva(LocalDateTime.now()); // Seteamos la fecha actual

        // 5. Guardar y devolver
        Reserva reservaGuardada = reservaRepository.save(nuevaReserva);
        return reservaMapper.toDTO(reservaGuardada);
    }

    @Override
    public List<ReservaDTO> obtenerTodasLasReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(reservaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReservaDTO> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id)
                .map(reservaMapper::toDTO);
    }

    @Override
    public List<ReservaDTO> obtenerReservasPorSocio(String dni) {
        return reservaRepository.findBySocioDni(dni)
                .stream()
                .map(reservaMapper::toDTO)
                .collect(Collectors.toList());
    }
}