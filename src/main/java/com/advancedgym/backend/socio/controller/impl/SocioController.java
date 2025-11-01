package com.advancedgym.backend.socio.controller.impl; // O controller.impl

import com.advancedgym.backend.socio.controller.SocioAPI;
import com.advancedgym.backend.socio.model.SocioDTO;
import com.advancedgym.backend.socio.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socios")
public class SocioController implements SocioAPI { // <-- ¡Añade "implements SocioAPI"!

    @Autowired
    private SocioService socioService;

    @Override // <-- Añade @Override para indicar que cumples el contrato
    public ResponseEntity<SocioDTO> crearSocio(@RequestBody SocioDTO socioDTO) {
        SocioDTO nuevoSocio = socioService.crearSocio(socioDTO);
        return new ResponseEntity<>(nuevoSocio, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<SocioDTO>> obtenerTodosLosSocios() {
        List<SocioDTO> socios = socioService.obtenerTodosLosSocios();
        return new ResponseEntity<>(socios, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SocioDTO> obtenerSocioPorDni(@PathVariable String dni) {
        return socioService.obtenerSocioPorDni(dni)
                .map(socioDTO -> new ResponseEntity<>(socioDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}