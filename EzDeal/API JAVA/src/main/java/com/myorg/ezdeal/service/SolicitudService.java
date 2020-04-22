package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Solicitud;

import java.util.List;

public interface SolicitudService {
    List<Solicitud> listarSolicitudes() throws Exception;
    Solicitud publicarSolicitud(Solicitud solicitud) throws  Exception;
}
