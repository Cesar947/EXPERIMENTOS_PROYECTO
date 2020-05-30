package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Cita;
import com.myorg.ezdeal.repository.CitaRepository;
import com.myorg.ezdeal.service.CitaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class CitaServiceImpl implements CitaService {

    private CitaRepository citaRepository;

    @Autowired
    public CitaServiceImpl(CitaRepository citaRepository){
        this.citaRepository = citaRepository;
    }

    @Override
    @Transactional
    public int actualizarEstadoCita(String estado, Long citaId) throws Exception{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime hora = LocalTime.parse(LocalTime.now().format(dtf));
        if (estado.equals("Iniciada")){
            this.citaRepository.actualizarHoraInicioCita(hora, citaId);
        }
        else if (estado.equals("Finalizada")){
            this.citaRepository.actualizarHoraFinCita(hora, citaId);
         }
        return this.citaRepository.actualizarEstadoCita(estado, citaId);
    }

    @Override
    @Transactional
    public int actualizarCostoFinalCita(BigDecimal costoFinal, Long citaId) throws Exception{
        return this.citaRepository.actualizarCostoFinalCita(costoFinal, citaId);
    }

    @Override
    public Cita listarPorId(Long citaId) throws Exception{
        return this.citaRepository.findById(citaId).get();
    }

    @Override
    public List<Cita> listarCitasDeUsuario(Long usuarioId) throws Exception{
        return this.citaRepository.listarCitasDeUsuario(usuarioId);
    }

}
