package com.myorg.ezdeal;

import com.myorg.ezdeal.models.*;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.Implementation.SolicitudServiceImpl;
import com.myorg.ezdeal.service.Implementation.UsuarioServiceImpl;
import com.myorg.ezdeal.service.ReseñaService;
import com.myorg.ezdeal.service.SolicitudService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolicitudServiceTest {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReseñaService reseñaService;

    @Autowired
    private ReseñaRepository reseñaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private SolicitudRepository solicitudRepository;

    //private Solicitud solicitud;
    private String estado;
    private Servicio servicio;
    private Usuario clientePrueba;

    @Before
    public void init(){
        clientePrueba = usuarioRepository.findById(new Long(1)).get();
        servicio = servicioRepository.findById(new Long(1)).get();
    }

   /* @Test
    @Transactional
    public void actualizarEstadoSolicitud() throws Exception{

        estado = "Iniciado";
        Long solicitudId = new Long(1);
        int estadoActualizado = solicitudService.actualizarEstadoSolicitud(estado, solicitudId);
        assertEquals(1, estadoActualizado);
        Reseña reseña = new Reseña("Nunca te solicite xd", 4.0);
        reseñaService.publicarReseña(reseña, clientePrueba.getId(), servicio.getId());
    }*/

    @Test
    @Transactional
    public void reseñarServicioFinalizado() throws Exception{
        this.estado = "Iniciado";
        Long solicitudId = new Long(1);
        int estadoActualizado1 = solicitudService.actualizarEstadoSolicitud(estado, solicitudId);
        assertEquals(1, estadoActualizado1);
        Reseña reseña = new Reseña("Nunca te solicite xd", 4.0);
        Reseña reseñaGuardada = reseñaService.publicarReseña(reseña, clientePrueba.getId(), servicio.getId());
        System.out.println(reseña);
        assertEquals(new Reseña(), reseñaGuardada);

        String estado1 = "Finalizado";
        int estadoActualizado2 = solicitudService.actualizarEstadoSolicitud(estado1, solicitudId);
        assertEquals(1, estadoActualizado2);
        reseñaGuardada = reseñaService.publicarReseña(reseña, clientePrueba.getId(), servicio.getId());
        System.out.println(reseñaGuardada);
        Reseña reseñaPrueba = reseñaRepository.findById(reseñaGuardada.getId()).get();
        assertEquals(reseñaGuardada, reseñaPrueba);
    }

/*
    @Test
    public void validaciónDeReseñaHabilitada() throws Exception{



    }*/

}