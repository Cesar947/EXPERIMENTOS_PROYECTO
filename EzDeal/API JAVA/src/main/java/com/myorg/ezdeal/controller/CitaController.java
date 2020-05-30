package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Cita;
import com.myorg.ezdeal.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/citas")
public class CitaController {

    private CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService){
        this.citaService = citaService;
    }

    @GetMapping("/{id}")
    public Cita mostrarCitaPorId(@PathVariable("id") Long citaId) throws Exception{
        return this.citaService.listarPorId(citaId);
    }

    @Transactional
    @PutMapping("/{id}/actualizacionEstado")
    public int actualizarEstadoCita(@RequestParam("estado") String estado, @PathVariable("id") Long citaId) throws Exception{
        return this.citaService.actualizarEstadoCita(estado, citaId);
    }

    @Transactional
    @PutMapping("/{id}/actualizacionCosto")
    public int actualizarCostoFinalCita(@RequestParam("costoFinal") double costoFinal, @PathVariable("id") Long citaId) throws Exception{
        BigDecimal costo = BigDecimal.valueOf(costoFinal);
        return this.citaService.actualizarCostoFinalCita(costo, citaId);
    }

}
