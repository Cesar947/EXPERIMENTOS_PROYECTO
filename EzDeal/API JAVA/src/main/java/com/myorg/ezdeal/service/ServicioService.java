package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Servicio;

import java.util.List;

public interface ServicioService {

    Servicio publicarServicio(Servicio servicio) throws Exception;
    List<Servicio> listarServicios() throws Exception;
}
