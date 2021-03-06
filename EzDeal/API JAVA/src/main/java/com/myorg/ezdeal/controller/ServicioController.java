package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.service.ServicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servicios")
@Slf4j
public class ServicioController {

    private ServicioService servicioService;

    @Autowired
    public ServicioController(final ServicioService servicioService){
        this.servicioService = servicioService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Servicio publicarServicio(final @RequestBody Servicio servicio,
                                     final @RequestParam(value = "tipoServicioId" , required = true) Long tipoServicioId,
                                     final @RequestParam(value="anuncianteId", required = true) Long anuncianteId) throws Exception{


        log.info("***********************");
        log.info(tipoServicioId.toString());
        log.info(anuncianteId.toString());

        return this.servicioService.publicarServicio(servicio, anuncianteId, tipoServicioId);
    }

    //@CrossOrigin(origins = "*",allowCredentials = "*" ,allowedHeaders = "*" , exposedHeaders = "*", methods = "*" )

    @GetMapping("/lista")
    public List<Servicio> listarServicios() throws Exception{
        return this.servicioService.listarServicios();
    }


    @GetMapping("/titulo")
    public List<Servicio> listarServiciosPorTitulo(final @RequestParam(value = "keyword", required = true) String keyword) throws Exception{

        return this.servicioService.listarServiciosPorTitulo(keyword);
    }

    @GetMapping("/{id}")
    public Servicio mostrarDetalleServicio(@PathVariable("id") Long servicioId) throws Exception{
        return this.servicioService.mostrarDetalleServicio(servicioId);
    }

    @GetMapping("/anunciante/{anuncianteId}")
    public List<Servicio> obtenerMisServicios(@PathVariable("anuncianteId") Long anuncianteId) throws Exception{
        return this.servicioService.listarServicioPorAnunciante(anuncianteId);
    }

}
