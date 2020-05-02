package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.ComprobantePago;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ComprobantePagoService {

    ComprobantePago insertarComprobante(Map<String,String> body) throws  Exception;

}
