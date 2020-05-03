package com.myorg.ezdeal.service;


import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.models.Solicitud;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SolicitudService {
    Solicitud listarSolicitudDeId(Long id) throws Exception;

    List<Solicitud> listarSolicitudes() throws Exception;

    Solicitud solicitar(Solicitud solicitud) throws Exception;

    Solicitud reagendarCita(Agenda cita, Long solicitudId) throws Exception;

    @Transactional
    int actualizarEstadoSolicitud(String estado, Long SolicitudId) throws Exception;


}
