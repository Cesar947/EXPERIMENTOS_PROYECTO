package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Solicitud;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {


    private SolicitudRepository solicitudRepository;
    private ServicioRepository servicioRepository;
    private UsuarioRepository clienteRepository;

    @Autowired
    public SolicitudServiceImpl(SolicitudRepository solicitudRepository, ServicioRepository servicioRepository, UsuarioRepository clienteRepository){
        this.solicitudRepository = solicitudRepository;
        this.servicioRepository = servicioRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Solicitud solicitar(Solicitud solicitud, Long servicioId, Long clienteId) throws Exception {
        Usuario cliente = clienteRepository.findById(clienteId).get();
        Servicio servicio = servicioRepository.findById(servicioId).get();

        solicitud.setCliente(cliente);
        solicitud.setServicio(servicio);

        return this.solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud reagendarCita(Agenda cita, Long solicitudId) throws Exception {
        Solicitud solicitudParaReagendar = solicitudRepository.findById(solicitudId).get();
        cita.setSolicitud(solicitudParaReagendar);
        solicitudParaReagendar.getCitas().add(cita);
        return solicitudRepository.save(solicitudParaReagendar);
    }
}
