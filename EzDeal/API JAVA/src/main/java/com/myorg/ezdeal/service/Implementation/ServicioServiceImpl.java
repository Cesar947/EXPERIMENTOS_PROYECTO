package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.TipoServicio;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.TipoServicioRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.ServicioService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServicioServiceImpl  implements ServicioService {

    private ServicioRepository servicioRepository;
    private UsuarioRepository usuarioRepository;
    private TipoServicioRepository tipoServicioRepository;


    private ServicioServiceImpl(ServicioRepository servicioRepository){
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Servicio publicarServicio(Servicio servicio, Integer anuncianteId, Integer tipoServicioId, String fecha) throws Exception{

       Usuario anunciante = usuarioRepository.findById(anuncianteId).get();
       servicio.setAnunciante(anunciante);
       TipoServicio tipoServicio = tipoServicioRepository.findById(tipoServicioId).get();
       servicio.setTipoServicio(tipoServicio);
       Date fechaConvertida = ParseFecha(fecha);
       servicio.setFechaPublicacion(fechaConvertida);
       return this.servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> listarServicios() throws Exception{
         return this.servicioRepository.listarServicios();
    }

    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
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
