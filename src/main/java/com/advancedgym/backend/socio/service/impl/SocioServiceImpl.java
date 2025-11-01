package com.advancedgym.backend.socio.service.impl;

import com.advancedgym.backend.socio.util.SocioMapper;
import com.advancedgym.backend.socio.model.Socio;
import com.advancedgym.backend.socio.model.SocioDTO;
import com.advancedgym.backend.socio.repository.SocioRepository;
import com.advancedgym.backend.socio.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioServiceImpl implements SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private SocioMapper socioMapper; // <-- Inyecta tu mapper manual

    @Override
    public SocioDTO crearSocio(SocioDTO socioDTO) {
        // Usa el mapper para la conversión
        Socio socio = socioMapper.toEntity(socioDTO);

        // IMPORTANTE: Como la contraseña no viene en el DTO, la asignamos aquí.
        // Por ahora ponemos un valor temporal. En un futuro, aquí se encriptaría.
        socio.setContraseña("passwordPorDefecto");

        Socio socioGuardado = socioRepository.save(socio);

        // Usa el mapper para devolver el DTO
        return socioMapper.toDTO(socioGuardado);
    }

    @Override
    public List<SocioDTO> obtenerTodosLosSocios() {
        return socioRepository.findAll()
                .stream()
                .map(socioMapper::toDTO) // Llama al metodo toDTO para cada socio
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SocioDTO> obtenerSocioPorDni(String dni) {
        return socioRepository.findById(dni)
                .map(socioMapper::toDTO); // Llama al metodo toDTO si encuentra el socio
    }
}