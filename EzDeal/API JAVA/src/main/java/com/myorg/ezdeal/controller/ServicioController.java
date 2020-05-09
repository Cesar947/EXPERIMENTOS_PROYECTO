package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.service.ServicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/todos")
    public List<Servicio> listarServicios() throws Exception{
        return this.servicioService.listarServicios();
    }


    @GetMapping("/titulo")
    public List<Servicio> listarServiciosPorTitulo(final @RequestParam(value = "keyword", required = true) String keyword) throws Exception{

        return this.servicioService.listarServiciosPorTitulo(keyword);
    }

    @GetMapping
    public List<Servicio> listarPorMembresia(final @RequestParam("membresiaId") Long membresiaId) throws Exception{
        return this.servicioService.listarPorMembresia(membresiaId);
    }

    /*
    @GetMapping("/titulo")
    public List<Servicio> listarServiciosPorTitulo(@RequestParam(value = "titulo", required = true) String titulo) throws Exception{
        return this.servicioService.findByTituloLike("%"+titulo+"%");
    }

     */
}
