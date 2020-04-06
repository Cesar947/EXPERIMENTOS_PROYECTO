package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByEmail(String email);
    Cuenta findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
    Boolean existsByEmail(String email);
    Boolean existsByNombreUsuario(String nombreUsuario);
    Cuenta findByNombreUsuario(String nombreUsuario);
}
