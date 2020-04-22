package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Reseña;

import java.util.List;

public interface ReseñaService{

    Reseña publicarReseña(Reseña reseña, Long clienteId, Long servicioId) throws Exception;
    List<Reseña> listarReseñasPorServicio(Long servicioId) throws Exception;
    List<Reseña> listarReseñas() throws Exception;
}
