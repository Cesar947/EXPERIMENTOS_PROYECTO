package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Solicitud;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudServiceImpl(SolicitudRepository solicitudRepository){
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public List<Solicitud> listarSolicitudes() throws Exception {
        return this.solicitudRepository.findAll();
    }

    public Solicitud publicarSolicitud(Solicitud solicitud) throws Exception{

        return this.solicitudRepository.save(solicitud);
    }
}
