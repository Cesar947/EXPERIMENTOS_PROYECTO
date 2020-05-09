package com.myorg.ezdeal.controller;
import com.myorg.ezdeal.models.ComprobantePago;
import com.myorg.ezdeal.service.ComprobantePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/comprobante")
public class ComprobantePagoController {

    @Autowired
    private ComprobantePagoService comprobantePagoService;

    @Autowired
    public ComprobantePagoController(final ComprobantePagoService comprobantePagoService){
        this.comprobantePagoService = comprobantePagoService;
    }

    @PostMapping
    public ComprobantePago generarComprobante(final @RequestBody Map<String, String> body) throws Exception {
        return comprobantePagoService.insertarComprobante(body);
    }

}
