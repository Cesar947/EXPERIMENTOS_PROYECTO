package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.models.Solicitud;

public interface SolicitudService {

    Solicitud solicitar(Solicitud solicitud, Long servicioId, Long clienteId) throws Exception;

    Solicitud reagendarCita(Agenda cita, Long solicitudId) throws Exception;


}
