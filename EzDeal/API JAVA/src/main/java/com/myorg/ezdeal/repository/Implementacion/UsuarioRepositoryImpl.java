package com.myorg.ezdeal.repository.Implementacion;

import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.UsuarioRepository;

import java.util.Optional;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    Optional<Usuario> findByEmail(String email){

    }
    
    Boolean existsByEmail(String email){

    }
}
