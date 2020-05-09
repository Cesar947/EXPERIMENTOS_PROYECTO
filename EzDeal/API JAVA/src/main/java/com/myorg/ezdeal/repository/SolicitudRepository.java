package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    @Modifying
    @Query("UPDATE Solicitud s SET s.estado = ?1 where s.id = ?2")
    int actualizarEstadoSolicitud(String estado, Long solicitudId);


    @Query("select s from Solicitud s JOIN Usuario u ON u.id = s.cliente.id JOIN Servicio se ON se.id = s.servicio.id WHERE u.id = ?1 AND se.id = ?2 AND s.estado = 'Finalizado'")
    List<Solicitud> listarPorClienteYServicio(Long clienteId, Long servicioId);

}
