package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Servicio;

import java.util.List;

public interface ServicioService {

    Servicio publicarServicio(Servicio servicio, Long anuncianteId, Long tipoServicioId) throws Exception;
    List<Servicio> listarServicios() throws Exception;

    List<Servicio>listarServiciosPorTitulo(String keyword) throws Exception;

    List<Servicio> listarPorMembresia(Long membresiaId) throws Exception;
}
