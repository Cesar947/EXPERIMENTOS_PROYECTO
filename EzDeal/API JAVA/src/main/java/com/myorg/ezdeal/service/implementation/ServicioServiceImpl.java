package com.myorg.ezdeal.service.implementation;

import com.myorg.ezdeal.models.Horario;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.TipoServicio;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.HorarioRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.TipoServicioRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.ServicioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ServicioServiceImpl  implements ServicioService {

    private ServicioRepository servicioRepository;
    private UsuarioRepository usuarioRepository;
    private TipoServicioRepository tipoServicioRepository;
    private HorarioRepository horarioRepository;


    @Autowired
    private ServicioServiceImpl(ServicioRepository servicioRepository, UsuarioRepository usuarioRepository, TipoServicioRepository tipoServicioRepository,
                                HorarioRepository horarioRepository){
        this.servicioRepository = servicioRepository;
        this.usuarioRepository = usuarioRepository;
        this.tipoServicioRepository = tipoServicioRepository;
        this.horarioRepository = horarioRepository;
    }

    @Override
    public Servicio publicarServicio(Servicio servicio, Long anuncianteId, Long tipoServicioId) throws Exception{
        log.info("//////////////////////////////////////////////////");
        log.info("Estamos dentro");
        log.info(servicio.toString());
        log.info("//////////////////////////////////////////////////");
       Usuario user = usuarioRepository.findById(anuncianteId).get();
       servicio.setAnunciante(user);
       servicio.setEstaHabilitado(true);
       servicio.setValoracion(0.0);
       TipoServicio tipoServicio = tipoServicioRepository.findById(tipoServicioId).get();
       servicio.setTipoServicio(tipoServicio);


        for(Horario h: servicio.getHorarios()){

            h.setServicio(servicio);
        }
       servicio.setFechaPublicacion(LocalDate.now());

       return this.servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> listarServicios() throws Exception{
         return this.servicioRepository.listarServicios();
    }



    @Override
    public List<Servicio> listarServiciosPorTitulo(String keyword) throws Exception {

        if(keyword != "") {
            keyword = "%" + keyword + "%";
        }
        return this.servicioRepository.listarServiciosPorTitulo(keyword);
    }

    @Override
    public List<Servicio> listarPorMembresia(Long membresiaId) throws Exception{
            return servicioRepository.listarPorMembresia(membresiaId);
    }



    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }


}
