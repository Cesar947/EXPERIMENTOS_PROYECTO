package com.myorg.ezdeal.service.implementation;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Solicitud;

import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.models.Agenda;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private SolicitudRepository solicitudRepository;
    private ServicioRepository servicioRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public SolicitudServiceImpl(SolicitudRepository solicitudRepository, ServicioRepository servicioRepository, UsuarioRepository usuarioRepository){
        this.solicitudRepository = solicitudRepository;
        this.servicioRepository = servicioRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Solicitud> listarSolicitudes() throws Exception {
        return this.solicitudRepository.findAll();
    }

    public Solicitud solicitar(Solicitud solicitud, Long clienteId, Long servicioId) throws Exception{
        List<Solicitud> solicitudesRealizadas = solicitudRepository.listarPorFechaYServicio(solicitud.getFechaPactada(), servicioId);
        for (Solicitud sRealizada: solicitudesRealizadas){
                //Si la hora pactada que está por enviarse está dentro del rango de horas de otra solicitud ya agendada,
                //no se podrá enviar la solicitud
                if(!solicitud.getHoraPactada().isBefore(sRealizada.getHoraPactada()) ||
                        !solicitud.getHoraPactada().isAfter(sRealizada.getHoraFinEstimada())){
                    return new Solicitud();
                }
        }
        Usuario cliente = usuarioRepository.findById(clienteId).get();
        Servicio servicio = servicioRepository.findById(servicioId).get();
        solicitud.setServicio(servicio);
        solicitud.setCliente(cliente);
        return this.solicitudRepository.save(solicitud);
    }


    @Transactional
    public int actualizarHoraFin(LocalTime nuevaHoraFin, Long solicitudId) throws Exception{
        return this.solicitudRepository.actualizarHoraFin(nuevaHoraFin, solicitudId);
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

