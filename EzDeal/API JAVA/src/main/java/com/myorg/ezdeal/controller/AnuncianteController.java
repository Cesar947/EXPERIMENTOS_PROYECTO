package com.myorg.ezdeal.controller;

import com.myorg.ezdeal.service.AnuncianteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/anunciantes")
public class AnuncianteController {

  /*  AnuncianteService anuncianteService;

    public AnuncianteController(AnuncianteService anuncianteService){
        this.anuncianteService = anuncianteService;
    }

    @PutMapping("/membresia/{nombreMembresia}")
    public int actualizarDatosMembresia(@PathVariable("nombreMembresia") final String nombreMembresia,
                                              @RequestParam("anuncianteId") final Long anuncianteId) throws Exception {

        return this.anuncianteService.actualizarDatosMembresia(nombreMembresia.toUpperCase(Locale.getDefault()), anuncianteId);

    }*/

    
}
