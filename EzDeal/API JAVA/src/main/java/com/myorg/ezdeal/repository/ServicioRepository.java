package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {


    @Query("SELECT s FROM Servicio s order by s.fechaPublicacion desc")
    List<Servicio> listarServicios() throws Exception;
}
