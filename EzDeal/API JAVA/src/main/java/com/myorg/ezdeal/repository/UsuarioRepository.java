package com.myorg.ezdeal.repository;


import com.myorg.ezdeal.models.Cuenta;
import com.myorg.ezdeal.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario getByCuentaId(Cuenta cuenta);

}
