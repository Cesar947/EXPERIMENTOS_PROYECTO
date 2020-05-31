package com.myorg.ezdeal.service.implementation;
import com.myorg.ezdeal.models.*;

import com.myorg.ezdeal.repository.CitaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class SolicitudServiceImpl implements SolicitudService {

    private SolicitudRepository solicitudRepository;
    private CitaRepository citaRepository;
    private ServicioRepository servicioRepository;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public SolicitudServiceImpl(SolicitudRepository solicitudRepository, ServicioRepository servicioRepository, UsuarioRepository usuarioRepository, CitaRepository citaRepository){
        this.solicitudRepository = solicitudRepository;
        this.servicioRepository = servicioRepository;
        this.usuarioRepository = usuarioRepository;
        this.citaRepository = citaRepository;
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
        solicitud.setEstado("Enviada");
        solicitud.setFechaSolicitud(LocalDate.now());

        Solicitud solicitudGuardada = this.solicitudRepository.save(solicitud);

        return solicitudGuardada;
    }

    @Transactional
    public int actualizarEstadoSolicitud(String estado, String horaFin, String motivoRechazo, Long solicitudId) throws Exception {
        int actualizacionExitosa = 0;
        Solicitud solicitud = this.solicitudRepository.findById(solicitudId).get();
        if (estado.equals("Rechazada") && motivoRechazo != ""){
            this.solicitudRepository.actualizarMotivoRechazo(motivoRechazo, solicitudId);
            actualizacionExitosa = this.solicitudRepository.actualizarEstadoSolicitud(estado, solicitudId);
        }
        else if(estado.equals("Aceptada") && horaFin != ""){

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime nuevaHoraFin = LocalTime.parse(horaFin, dtf).plusMinutes(10);
            this.solicitudRepository.actualizarHoraFin(nuevaHoraFin, solicitudId);
            actualizacionExitosa = this.solicitudRepository.actualizarEstadoSolicitud(estado, solicitudId);
            Cita citaGenerada = new Cita();
            citaGenerada.setSolicitud(solicitud);
            citaGenerada.setEstado("Creada");
            this.citaRepository.save(citaGenerada);
        }

        return actualizacionExitosa;

    }

    @Override
    public List<Solicitud> listarPorClienteYServicio(Long clienteId, Long servicioId, String estado) {
        return solicitudRepository.listarPorClienteYServicio(clienteId, servicioId, estado);
    }

    @Override
    public List<Solicitud> listarPorServicio(Long servicioId) throws Exception{
        return this.solicitudRepository.listarPorServicio(servicioId);
    }

    @Override
    public List<Solicitud> listarSolicitudesPorAnunciante(Long anuncianteId) throws Exception{
        return this.solicitudRepository.listarPorAnunciante(anuncianteId);
    }

}

