package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.TipoServicio;
import com.myorg.ezdeal.models.Usuario;
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

    @Autowired
    private ServicioServiceImpl(ServicioRepository servicioRepository, UsuarioRepository usuarioRepository, TipoServicioRepository tipoServicioRepository){
        this.servicioRepository = servicioRepository;
        this.usuarioRepository = usuarioRepository;
        this.tipoServicioRepository = tipoServicioRepository;
    }

    @Override
    public Servicio publicarServicio(Servicio servicio, Integer anuncianteId, Integer tipoServicioId) throws Exception{
       log.info("***************************");
       Usuario user = usuarioRepository.findById(anuncianteId).get();
       log.info("***************************");
       log.info(user.getNombres());
       servicio.setAnunciante(user);
       TipoServicio tipoServicio = tipoServicioRepository.findById(tipoServicioId).get();
       servicio.setTipoServicio(tipoServicio);
       servicio.setFechaPublicacion(LocalDate.now());
       log.info("***************************");
       log.info(servicio.toString());
       log.info("***************************");

       return this.servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> listarServicios() throws Exception{
         return this.servicioRepository.listarServicios();
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
