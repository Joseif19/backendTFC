package com.advancedgym.backend.pago.service.impl;

import com.advancedgym.backend.pago.model.Pago;
import com.advancedgym.backend.pago.model.PagoDTO;
import com.advancedgym.backend.pago.repository.PagoRepository;
import com.advancedgym.backend.pago.service.PagoService;
import com.advancedgym.backend.pago.util.PagoMapper;
import com.advancedgym.backend.socio.model.Socio;
import com.advancedgym.backend.socio.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private PagoMapper pagoMapper;

    @Override
    public PagoDTO crearPago(PagoDTO pagoDTO) {
        // 1. Validar que el socio existe
        Socio socio = socioRepository.findById(pagoDTO.getDniSocio())
                .orElseThrow(() -> new RuntimeException("Socio no encontrado"));

        // 2. Validar que no exista ya un pago para ese mes
        if (pagoRepository.existsBySocioDniAndMes(pagoDTO.getDniSocio(), pagoDTO.getMes())) {
            throw new RuntimeException("Ya existe un pago para este socio en este mes");
        }

        // 3. Convertir DTO a Entidad
        Pago pago = pagoMapper.toEntity(pagoDTO);
        pago.setSocio(socio);
        pago.setEstado(Pago.EstadoPago.NO_PAGADO); // Por defecto, un pago se crea como NO PAGADO

        // 4. Guardar y devolver
        Pago pagoGuardado = pagoRepository.save(pago);
        return pagoMapper.toDTO(pagoGuardado);
    }

    @Override
    public List<PagoDTO> obtenerPagosPorSocio(String dni) {
        return pagoRepository.findBySocioDni(dni)
                .stream()
                .map(pagoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PagoDTO> obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id)
                .map(pagoMapper::toDTO);
    }

    @Override
    public PagoDTO marcarComoPagado(Long id) {
        // 1. Encontrar el pago
        Pago pago = pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));

        // 2. Actualizar el estado
        pago.setEstado(Pago.EstadoPago.PAGADO);

        // 3. Guardar y devolver
        Pago pagoActualizado = pagoRepository.save(pago);
        return pagoMapper.toDTO(pagoActualizado);
    }
}