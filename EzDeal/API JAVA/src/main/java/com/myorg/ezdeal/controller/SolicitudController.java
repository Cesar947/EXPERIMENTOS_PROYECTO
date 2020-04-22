package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Solicitud;
import com.myorg.ezdeal.service.SolicitudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@Slf4j
public class SolicitudController {

    private SolicitudService solicitudService;

    @Autowired
    public SolicitudController(SolicitudService solicitudService){
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public List<Solicitud> listarSolicitudes() throws Exception{
        return this.solicitudService.listarSolicitudes();
    }

    @PostMapping
    public Solicitud publicarSolicitud(@RequestBody Solicitud solicitud) throws Exception{
        return this.solicitudService.publicarSolicitud(solicitud);
    }

}
