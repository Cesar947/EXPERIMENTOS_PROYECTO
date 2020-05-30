package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Cita;
import com.myorg.ezdeal.models.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Modifying
    @Query("UPDATE Cita c SET c.estado = ?1 where c.id = ?2")
    int actualizarEstadoCita(String Estado, Long citaId);

    @Modifying
    @Query("UPDATE Cita c SET c.horaInicio = ?1 where c.id = ?2")
    int actualizarHoraInicioCita(LocalTime horaInicio, Long citaId);

    @Query("SELECT COUNT(c.id) FROM Cita c JOIN Solicitud s ON c.solicitud.id = s.id \n" +
            "WHERE s.servicio.id = ?1 and s.cliente.id = ?2 and c.estado = 'Finalizado'")
    int cantidadCitasFinalizadasPorClienteYServicio(Long servicioId, Long clienteId);

    @Modifying
    @Query("UPDATE Cita c SET c.horaFin = ?1 where c.id = ?2")
    int actualizarHoraFinCita(LocalTime horaFin, Long citaId);

    @Modifying
    @Query("UPDATE Cita c SET c.costoFinal = ?1 where c.id = ?2")
    int actualizarCostoFinalCita(BigDecimal costoFinal, Long citaId);

    @Query("SELECT c FROM Cita c where c.solicitud.cliente.id = ?1")
    List<Cita> listarCitasDeUsuario(Long usuarioId);

}
