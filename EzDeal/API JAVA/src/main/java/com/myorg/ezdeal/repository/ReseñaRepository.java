package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Long> {

    @Query("SELECT r FROM Reseña r where r.servicio.id = ?1")
    List<Reseña> listarReseñasPorServicio(Long servicioId);

    @Query("SELECT COUNT(r.id) FROM Reseña r where r.valoracion < 2.5 and r.servicio.id = ?1")
    int cantidadReseñasNegativasPorServicio(Long servicioId);

    Reseña findByContenido(String contenido);

    @Modifying
    @Query("UPDATE Reseña r SET r.contenido = ?1, r.valoracion = ?2 where r.servicio.id = ?3 and r.cliente.id = ?4")
    int actualizarReseña(String contenido, double valoracion, Long servicioId, Long clienteId);

    @Query("SELECT COUNT(r.id) FROM Reseña r WHERE r.servicio.id = ?1")
    Double cantidadReseñasPorServicio(Long servicioId);
}
