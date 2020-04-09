package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Horario;
import com.myorg.ezdeal.models.Servicio;

import java.util.List;

public interface ServicioService {

    Servicio publicarServicio(Servicio servicio, Long anuncianteId, Long tipoServicioId) throws Exception;
    List<Servicio> listarServicios() throws Exception;
}
