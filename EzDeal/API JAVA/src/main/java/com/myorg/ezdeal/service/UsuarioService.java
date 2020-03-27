package com.myorg.ezdeal.service;

import com.myorg.ezdeal.models.Usuario;

import java.util.List;


public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario) throws Exception;

    //Método de pruebas
    List<Usuario> listarUsuarios() throws Exception;

    Usuario verPerfil(Integer id) throws Exception;
}
