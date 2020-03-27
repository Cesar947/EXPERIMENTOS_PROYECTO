package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Reseña;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.ReseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseñaServiceImpl implements ReseñaService {


    private ReseñaRepository reseñaRepository;
    private ServicioRepository servicioRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public ReseñaServiceImpl(ReseñaRepository reseñaRepository, ServicioRepository servicioRepository, UsuarioRepository usuarioRepository){
        this.reseñaRepository = reseñaRepository;
        this.servicioRepository = servicioRepository;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Reseña publicarReseña(Reseña reseña, Integer clienteId, Integer servicioId) throws Exception {

        Usuario cliente = usuarioRepository.findById(clienteId).get();
        Servicio servicio = servicioRepository.findById(servicioId).get();

        reseña.setCliente(cliente);
        reseña.setServicio(servicio);

        return this.reseñaRepository.save(reseña);
    }

    @Override
    public List<Reseña> listarReseñasPorServicio(Integer servicioId) throws Exception {
        return this.reseñaRepository.listarReseñasPorServicio(servicioId);
    }
}

