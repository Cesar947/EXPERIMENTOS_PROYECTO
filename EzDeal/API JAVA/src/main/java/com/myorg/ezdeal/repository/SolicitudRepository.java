package com.myorg.ezdeal.repository;


import com.myorg.ezdeal.models.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    @Modifying
    @Query("UPDATE Solicitud s SET s.estado = ?1 where s.id = ?2")
    int actualizarEstadoSolicitud(String estado, Long solicitudId);

    @Modifying
    @Query("UPDATE Solicitud s SET s.horaFinEstimada = ?1 where s.id = ?2")
    int actualizarHoraFin(LocalTime horaFin, Long solicitudId);

    @Modifying
    @Query("UPDATE Solicitud s SET s.motivoRechazo = ?1 where s.id = ?2")
    int actualizarMotivoRechazo(String motivoRechazo, Long solicitudId);

    @Query("select s from Solicitud s JOIN Usuario u ON u.id = s.cliente.id JOIN Servicio se ON se.id = s.servicio.id WHERE u.id = ?1 AND se.id = ?2 AND s.estado = ?3")
    List<Solicitud> listarPorClienteYServicio(Long clienteId, Long servicioId, String estado);

    @Query("SELECT s FROM Solicitud s where s.fechaPactada = ?1 and s.servicio.id = ?2")
    List<Solicitud> listarPorFechaYServicio(LocalDate fecha, Long servicioId);

    @Query("SELECT s FROM Solicitud s where s.fechaPactada = ?1 and s.horaPactada = ?2 and s.servicio.id = ?3")
    List<Solicitud> listarPorFechaYHoraYServicio(LocalDate Fecha, LocalTime hora, Long servicioId);

    @Query("SELECT s FROM Solicitud s where s.servicio.id = ?1 order by s.id desc")
    List<Solicitud> listarPorServicio(Long servicioId);

    @Query("SELECT s FROM Solicitud s JOIN Servicio se ON se.id = s.servicio.id JOIN Usuario u ON u.id = se.anunciante.id WHERE u.id = ?1")
    List<Solicitud> listarPorAnunciante(Long anuncianteId);

}