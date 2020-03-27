package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Reseña;

import java.util.List;

public interface ReseñaService{

    Reseña publicarReseña(Reseña reseña, Integer clienteId, Integer servicioId) throws Exception;
    List<Reseña> listarReseñasPorServicio(Integer servicioId) throws Exception;
}
