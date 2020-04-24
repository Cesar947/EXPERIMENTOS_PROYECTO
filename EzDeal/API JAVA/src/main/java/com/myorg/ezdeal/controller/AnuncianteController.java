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

    /*
    Metodo para actualizar datos membresia
    Parametros:
        nombreMembresia: Tal y como está guardado en la BD
        anuncianteId: ID del anunciante al que está relacionada la cuenta del usuario en cuestión

        # Tarjeta
        CCV
        Fecha de Vencimiento
     */
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
