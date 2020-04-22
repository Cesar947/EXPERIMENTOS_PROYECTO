package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Anunciante;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncianteRepository extends JpaRepository<Anunciante, Integer> {
=======
import com.myorg.ezdeal.models.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface AnuncianteRepository extends JpaRepository<Anunciante, Long> {

    @Modifying
    @Query("UPDATE Anunciante a SET a.membresia = ?1 where a.id = ?2")
    int actualizarDatosMembresia(Membresia membresia, Long anuncianteId);
>>>>>>> master

}
