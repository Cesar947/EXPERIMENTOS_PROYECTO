package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Long> {

    @Query("SELECT r FROM Reseña r where r.servicio.id = ?1")
    List<Reseña> listarReseñasPorServicio(Long servicioId);

    @Query("SELECT COUNT(r.id) FROM Reseña r")
    int buscarReseñasNegativas(Long servicioId);

}
