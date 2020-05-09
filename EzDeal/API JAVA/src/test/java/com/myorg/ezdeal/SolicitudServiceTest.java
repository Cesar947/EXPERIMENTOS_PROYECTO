package com.myorg.ezdeal;

import com.myorg.ezdeal.models.*;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;

import com.myorg.ezdeal.repository.UsuarioRepository;

import com.myorg.ezdeal.service.ReseñaService;
import com.myorg.ezdeal.service.SolicitudService;
import org.hamcrest.Matchers;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
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


    //private Solicitud solicitud;
    private String estado;
    private Long solicitudId;
    private Long serviceId;
    private Long userId;

    @Before
    public void init(){
        estado = "Iniciado";
        solicitudId = new Long(1);
        serviceId = new Long(1);
        userId = new Long(1);
    }

    @Test
    @Transactional
    public void reseñarServicioFinalizado() throws Exception{

        List<Solicitud> solicitudesIni = new ArrayList<>();
        List<Solicitud> solicitudesFin = new ArrayList<>();
        solicitudesFin.add(new Solicitud());

        SolicitudService solicitudServiceMock = mock(SolicitudService.class);
        when(solicitudServiceMock.listarPorClienteYServicio(userId, serviceId, "Finalizado")).thenReturn(solicitudesFin);
        reseñaService.setSolicitudService(solicitudServiceMock);

        Reseña reseña = new Reseña("Buen servicio, gracias", 4.0);

        //Reseña reseñaGuardada = reseñaService.publicarReseña(reseña, userId, serviceId);
        //assertEquals(reseñaGuardada, new Reseña());

        //Esta prueba esta hecha para probar que con estado Finalizado si se guarda la resena
        solicitudService.actualizarEstadoSolicitud(estado, solicitudId);
        Reseña reseñaGuardada = reseñaService.publicarReseña(reseña, userId, serviceId);
        Reseña reseñaPrueba = reseñaRepository.findById(reseñaGuardada.getId()).get();
        //Probamos que la reseña si se guarda porque ahora si existe una solicitud finalizada
        assertEquals(reseñaGuardada, reseñaPrueba);
    }

}