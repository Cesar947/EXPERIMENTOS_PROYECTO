package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Anunciante;
import com.myorg.ezdeal.models.Membresia;
import org.springframework.transaction.annotation.Transactional;

public interface AnuncianteService {

    @Transactional
    Anunciante guardarDatosAnunciante(Anunciante anunciante) throws Exception;

    @Transactional
    int actualizarDatosMembresia(String nombreMembresia, Long anuncianteId) throws Exception;

}
