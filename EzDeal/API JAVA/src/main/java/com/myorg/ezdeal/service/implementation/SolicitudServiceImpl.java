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

        Cita citaGenerada = new Cita();
        citaGenerada.setSolicitud(solicitudGuardada);
        citaGenerada.setEstado("Pendiente");
        this.citaRepository.save(citaGenerada);

        return solicitudGuardada;
    }


    @Transactional
    public int actualizarHoraFin(String nuevaHoraFin, Long solicitudId) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime horaFin = LocalTime.parse(nuevaHoraFin, dtf);
        return this.solicitudRepository.actualizarHoraFin(horaFin, solicitudId);
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

    @Override
    public List<Solicitud> listarPorServicio(Long servicioId) throws Exception{
        return this.solicitudRepository.listarPorServicio(servicioId);
    }


}

