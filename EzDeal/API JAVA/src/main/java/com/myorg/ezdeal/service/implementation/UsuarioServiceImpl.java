package com.myorg.ezdeal.service.implementation;

import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.AnuncianteRepository;
import com.myorg.ezdeal.repository.MembresiaRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private AnuncianteRepository anuncianteRepository;
    private MembresiaRepository membresiaRepository;

    @Autowired
    public UsuarioServiceImpl( UsuarioRepository usuarioRepository, AnuncianteRepository anuncianteRepository, MembresiaRepository membresiaRepository){
        this.usuarioRepository = usuarioRepository;
        this.anuncianteRepository = anuncianteRepository;
        this.membresiaRepository = membresiaRepository;
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
    public Usuario verPerfil(Long id) throws Exception{
        return this.usuarioRepository.findById(id).get();
    }
    @Override
    @Transactional
    public int actualizarMembresia(String nombreMembresia, Long usuarioAnuncianteId) throws Exception{
        Usuario anunciante = usuarioRepository.findById(usuarioAnuncianteId).get();
        Long anuncianteId = anunciante.getId();
        Membresia membresia = membresiaRepository.buscarPorNombre(nombreMembresia);
        return this.anuncianteRepository.actualizarDatosMembresia(membresia, anuncianteId);

    }

    @Override
    public String obtenerNombreMembresia(Long id) throws Exception {
        return this.usuarioRepository.obtenerNombreMembresia(id);
    }
}
