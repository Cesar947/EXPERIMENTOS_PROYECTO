package com.myorg.ezdeal.service.implementation;

import com.myorg.ezdeal.models.ComprobantePago;
import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.repository.AnuncianteRepository;
import com.myorg.ezdeal.repository.ComprobantePagoRepository;
import com.myorg.ezdeal.repository.MembresiaRepository;
import com.myorg.ezdeal.service.ComprobantePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Service
public class ComprobantePagoServiceImpl implements ComprobantePagoService {


    @Autowired
    private AnuncianteRepository anuncianteRepository;

    @Autowired
    private ComprobantePagoRepository comprobantePagoRepository;

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Override
    public ComprobantePago insertarComprobante(Map<String,String> body) throws Exception {

        /*
        Se va a generar el comprobante de pago
        se actualiz la membresiaId
        Importe y producto lo recupera de la BD, de acuerdo a la membresia elegida
        Igv y montoTotal se van a calcular en el metodo
        Fecha y hora lo determina el API
        y el id del anunciante relacionado va a ser recuperado desde el token
         */

        ComprobantePago comprobantePago = new ComprobantePago();
        Membresia membresia = membresiaRepository.buscarPorNombre( body.get("membresiaNombre") );

        comprobantePago.setMonto(membresia.getCosto());
        comprobantePago.setMembresia(membresia);
        comprobantePago.setAnunciante( anuncianteRepository.findById( Long.valueOf(body.get("anuncianteId") )).get());
        comprobantePago.setIgv( comprobantePago.getMonto().multiply(BigDecimal.valueOf(0.18)));
        comprobantePago.setMontoNeto(comprobantePago.getMonto().add(comprobantePago.getIgv()));
        comprobantePago.setFechaPago(LocalDate.now());
        comprobantePago.setHoraPago(LocalTime.now());

        return comprobantePagoRepository.save(comprobantePago);
    }
}
