package com.myorg.ezdeal.service.implementation;
import com.myorg.ezdeal.models.Solicitud;

import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private SolicitudRepository solicitudRepository;

    @Autowired
    public SolicitudServiceImpl(SolicitudRepository solicitudRepository){
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public Solicitud listarSolicitudDeId(Long id) throws Exception{
        return this.solicitudRepository.findById(id).get();
    }

    @Override
    public List<Solicitud> listarSolicitudes() throws Exception {
        return this.solicitudRepository.findAll();
    }

    public Solicitud solicitar(Solicitud solicitud) throws Exception{

        return this.solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud reagendarCita(Agenda cita, Long solicitudId) throws Exception {
        Solicitud solicitudParaReagendar = solicitudRepository.findById(solicitudId).get();
        cita.setSolicitud(solicitudParaReagendar);
        solicitudParaReagendar.getCitas().add(cita);
        return solicitudRepository.save(solicitudParaReagendar);
    }

    @Transactional
    public int actualizarEstadoSolicitud(String estado, Long SolicitudId) throws Exception {
        int actualizo = 1;
        int noActualizo = 0;
        int actualizacionExitosa = this.solicitudRepository.actualizarEstadoSolicitud(estado, SolicitudId);
        if (actualizacionExitosa == actualizo) return actualizacionExitosa;
        else return noActualizo;
    }

    @Override
    public List<Solicitud> listarPorClienteYServicio(Long clienteId, Long servicioId, String estado) {
        return solicitudRepository.listarPorClienteYServicio(clienteId, servicioId, estado);
    }



}

