package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Horario;
import com.myorg.ezdeal.models.Servicio;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicioService {

    Servicio publicarServicio(Servicio servicio, Long anuncianteId, Long tipoServicioId) throws Exception;
    List<Servicio> listarServicios() throws Exception;

    List<Servicio>listarServiciosPorTitulo(String keyword) throws Exception;

    List<Servicio> findByTituloLike(String titulo) throws Exception;
    List<Servicio> listarPorMembresia(Long membresiaId) throws Exception;

    Servicio mostrarDetalleServicio(Long id) throws Exception;
}
