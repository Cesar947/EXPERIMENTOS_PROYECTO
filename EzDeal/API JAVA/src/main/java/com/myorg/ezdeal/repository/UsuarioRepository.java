package com.myorg.ezdeal.repository;


import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT m.nombre FROM Usuario u JOIN Anunciante a ON u.infoAnunciante.id = a.id JOIN Membresia m " +
            "ON m.id = a.membresia.id where u.id = ?1")
    String obtenerNombreMembresia(Long id);

}
