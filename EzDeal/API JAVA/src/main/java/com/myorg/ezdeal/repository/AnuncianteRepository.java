package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Anunciante;

import com.myorg.ezdeal.models.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncianteRepository extends JpaRepository<Anunciante, Long> {

    @Modifying
    @Query("UPDATE Anunciante a SET a.membresia = ?1 where a.id = ?2")
    int actualizarDatosMembresia(Membresia membresia, Long anuncianteId);



}
