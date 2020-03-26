package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.service.ServicioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioServiceImpl  implements ServicioService {

    private final ServicioRepository servicioRepository;

    private ServicioServiceImpl(ServicioRepository servicioRepository){
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Servicio publicarServicio(Servicio servicio) throws Exception{
        return this.servicioRepository.save(servicio);
    }

    @Override
    public List<Servicio> listarServicios() throws Exception{
         return this.servicioRepository.listarServicios();
    }


}
