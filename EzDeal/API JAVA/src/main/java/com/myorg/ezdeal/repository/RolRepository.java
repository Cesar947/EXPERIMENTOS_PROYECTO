package com.myorg.ezdeal.repository;

import com.myorg.ezdeal.models.ERole;
import com.myorg.ezdeal.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(ERole name);




}
