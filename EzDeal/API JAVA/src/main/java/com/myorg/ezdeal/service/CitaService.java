package com.myorg.ezdeal.service;


import com.myorg.ezdeal.models.Cita;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface CitaService {

    @Transactional
    int actualizarEstadoCita(String estado, Long citaId) throws Exception;

    @Transactional
    int actualizarCostoFinalCita(BigDecimal costoFinal, Long citaId) throws Exception;

    Cita listarPorId(Long citaId) throws Exception;

    List<Cita> listarCitasDeUsuario(Long usuarioId) throws Exception;
}
