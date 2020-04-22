package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.service.AnuncianteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/anunciantes")
@Slf4j
public class AnuncianteController {

    @Autowired
    AnuncianteService anuncianteService;

    @PutMapping("/membresia/{nombreMembresia}")
    public int actualizarDatosMembresia(@PathVariable("nombreMembresia") String nombreMembresia,
                                              @RequestParam("anuncianteId") Long anuncianteId) throws Exception {

        log.info("/////////////////////////////////////////");
        log.info(nombreMembresia);
        log.info(anuncianteId.toString());
        log.info("/////////////////////////////////////////");
        return this.anuncianteService.actualizarDatosMembresia(nombreMembresia, anuncianteId);

    }


}
