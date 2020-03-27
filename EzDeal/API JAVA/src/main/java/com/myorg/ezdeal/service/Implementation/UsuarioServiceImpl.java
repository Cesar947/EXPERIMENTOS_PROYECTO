package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl( UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) throws Exception{

         return this.usuarioRepository.save(usuario);

    }

    @Override
    public List<Usuario> listarUsuarios() throws Exception{
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario verPerfil(Integer id) throws Exception{
        return this.usuarioRepository.findById(id).get();
    }

}
