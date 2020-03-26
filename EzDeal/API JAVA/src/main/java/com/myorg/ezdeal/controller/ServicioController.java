package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

    private ServicioService servicioService;

    @Autowired
    public ServicioController(ServicioService servicioService){
        this.servicioService = servicioService;
    }

    @RequestMapping(path="/publicar", method = RequestMethod.POST)
    public Servicio publicarServicio(@RequestBody Servicio servicio,
                                     @RequestParam(value = "tipoServicioId" , required = true) Integer tipoServicioId,
                                     @RequestParam(value="anuncianteId", required = true) Integer anuncianteId,
                                     @RequestParam(value="fechaPub", required = true) String fecha) throws Exception{


        return this.servicioService.publicarServicio(servicio, anuncianteId, tipoServicioId, fecha);
    }

    @GetMapping("/anuncios")
    public List<Servicio> listarServicios() throws Exception{
        return this.servicioService.listarServicios();
    }


}
