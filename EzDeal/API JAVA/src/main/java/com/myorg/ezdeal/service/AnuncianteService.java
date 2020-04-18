package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Anunciante;
import org.springframework.transaction.annotation.Transactional;

public interface AnuncianteService {

    @Transactional
    Anunciante guardarDatosAnunciante(Anunciante anunciante) throws Exception;
}
