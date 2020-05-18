package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.models.Solicitud;
import com.myorg.ezdeal.service.SolicitudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/solicitudes")
@Slf4j
public class SolicitudController {

    private SolicitudService solicitudService;

    @Autowired
    public SolicitudController(final SolicitudService solicitudService){
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public List<Solicitud> listarSolicitudes() throws Exception{
        return this.solicitudService.listarSolicitudes();
    }

    @PostMapping
    public Solicitud publicarSolicitud(@RequestBody Solicitud solicitud,
                                       @RequestParam("clienteId") Long clienteId,
                                       @RequestParam("servicioId") Long servicioId) throws Exception{
        return this.solicitudService.solicitar(solicitud, clienteId, servicioId);
    }

    @PutMapping("/{id}")
    public int actualizarHoraFinEstimada(@RequestParam("horaFin") LocalTime horaFin, @PathVariable Long solicitudId) throws Exception{
        return this.solicitudService.actualizarHoraFin(horaFin, solicitudId);
    }



}
