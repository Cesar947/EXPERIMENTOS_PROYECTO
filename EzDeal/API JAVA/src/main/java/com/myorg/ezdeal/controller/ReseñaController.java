package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.Reseña;
import com.myorg.ezdeal.service.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenas")
public class ReseñaController {

    private ReseñaService reseñaService;


    @Autowired
    public ReseñaController(ReseñaService reseñaService){
        this.reseñaService = reseñaService;
    }


    @GetMapping("/{id}")
    public List<Reseña> listarReseñasPorServicio(@PathVariable Integer id) throws Exception {
        return this.reseñaService.listarReseñasPorServicio(id);
    }

    @PostMapping("/publicar")
    public Reseña publicarReseña(@RequestBody Reseña reseña,
                                 @RequestParam(value="servicioId", required=true) Integer servicioId,
                                 @RequestParam(value="clienteId", required=true) Integer clienteId) throws Exception {
        return this.reseñaService.publicarReseña(reseña,clienteId ,servicioId);
    }




}
