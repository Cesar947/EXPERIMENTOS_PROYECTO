package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.service.ServicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/servicios")
@Slf4j
@Secured({ "ROL_ADMIN" })
public class ServicioController {

    private ServicioService servicioService;

    @Autowired
    public ServicioController(ServicioService servicioService){
        this.servicioService = servicioService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Servicio publicarServicio(@RequestBody Servicio servicio,
                                     @RequestParam(value = "tipoServicioId" , required = true) Long tipoServicioId,
                                     @RequestParam(value="anuncianteId", required = true) Long anuncianteId) throws Exception{


        log.info("***********************");
        log.info(tipoServicioId.toString());
        log.info(anuncianteId.toString());

        return this.servicioService.publicarServicio(servicio, anuncianteId, tipoServicioId);
    }

    @GetMapping
    @Secured({ "ROL_ANUNCIANTE, ROL_CLIENTE" })
    public List<Servicio> listarServicios() throws Exception{
        return this.servicioService.listarServicios();
    }


    @GetMapping("/titulo")
    public List<Servicio> listarServiciosPorTitulo(@RequestParam(value = "keyword", required = true) String keyword) throws Exception{

        return this.servicioService.listarServiciosPorTitulo(keyword);
    }


    /*
    @GetMapping("/titulo")
    public List<Servicio> listarServiciosPorTitulo(@RequestParam(value = "titulo", required = true) String titulo) throws Exception{
        return this.servicioService.findByTituloLike("%"+titulo+"%");
    }

     */
}
