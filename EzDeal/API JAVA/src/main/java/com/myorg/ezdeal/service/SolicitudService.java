package com.myorg.ezdeal.service;


import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.models.Solicitud;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface SolicitudService {

    List<Solicitud> listarSolicitudes() throws Exception;

    Solicitud solicitar(Solicitud solicitud, Long clienteId, Long servicioId) throws Exception;

    @Transactional
    int actualizarEstadoSolicitud(String estado, String horaFin, Map<String, String> motivoRechazo, Long solicitudId) throws Exception;

    List<Solicitud> listarPorClienteYServicio(Long clienteId, Long servicioId, String estado);


    List<Solicitud> listarPorServicio(Long servicioId) throws Exception;

    List<Solicitud> listarSolicitudesPorAnunciante(Long anuncianteId) throws Exception;

    List<Solicitud> listarSolicitudesPorCliente(Long clienteId)throws Exception;
}
