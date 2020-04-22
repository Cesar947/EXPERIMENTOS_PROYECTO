package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MembresiaRepository extends JpaRepository<Membresia, Long> {

    @Query("SELECT m FROM Membresia m WHERE m.nombre = ?1")
    Membresia buscarPorNombre(String nombre);
}
