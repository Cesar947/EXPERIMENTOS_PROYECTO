package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.models.Solicitud;
import com.myorg.ezdeal.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping
    public Solicitud solicitar(@RequestBody Solicitud solicitud,
                               @RequestParam("servicioId") Long servicioId,
                               @RequestParam("clienteId") Long clienteId) throws Exception{

        return this.solicitudService.solicitar(solicitud, servicioId, clienteId);

    }

    @PutMapping("/{id}")
    public Solicitud reagendarCita(@PathVariable("id") Long solicitudId, @RequestBody Agenda cita) throws Exception{
        return this.solicitudService.reagendarCita(cita, solicitudId);
    }


}
