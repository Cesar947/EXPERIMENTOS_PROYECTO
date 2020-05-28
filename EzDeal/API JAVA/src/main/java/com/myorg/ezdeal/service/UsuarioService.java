package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Usuario;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    //Método de pruebas
    List<Usuario> listarUsuarios() throws Exception;

    Usuario verPerfil(Long id) throws Exception;

    @Transactional
    int actualizarMembresia(String nombreMembresia, Long usuarioAnuncianteId) throws Exception;

    String obtenerNombreMembresia(Long id) throws Exception;
}
