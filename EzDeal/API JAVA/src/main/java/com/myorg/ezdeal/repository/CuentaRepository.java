package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Cuenta findByNombreUsuario(String nombreUsuario);
    Boolean existsByEmail(String email);
    Boolean existsByNombreUsuario(String nombreUsuario);

}
