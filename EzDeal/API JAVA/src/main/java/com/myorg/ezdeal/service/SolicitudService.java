package com.myorg.ezdeal.service;


import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.models.Solicitud;

import java.util.List;

public interface SolicitudService {
    List<Solicitud> listarSolicitudes() throws Exception;

    Solicitud solicitar(Solicitud solicitud) throws Exception;

    Solicitud reagendarCita(Agenda cita, Long solicitudId) throws Exception;
}
