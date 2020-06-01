package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Reseña;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.SolicitudRepository;

import java.util.List;

public interface ReseñaService{

    Reseña publicarReseña(Reseña reseña, Long clienteId, Long servicioId) throws Exception;
    List<Reseña> listarReseñasPorServicio(Long servicioId) throws Exception;
    List<Reseña> listarReseñas() throws Exception;
    double porcentajeReseñasNegativas(Long servicioId) throws Exception;
    void inhabilitarServicio(Long servicioId) throws Exception;
    void setSolicitudService(SolicitudService solicitudService);
}
