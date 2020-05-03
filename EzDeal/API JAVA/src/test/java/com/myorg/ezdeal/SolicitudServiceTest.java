package com.myorg.ezdeal;

import com.myorg.ezdeal.models.*;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.SolicitudRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.ReseñaService;
import com.myorg.ezdeal.service.SolicitudService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SolicitudServiceTest {

    @Autowired
    private  SolicitudService solicitudService;

    @Autowired
    private  UsuarioRepository usuarioRepository;

    @Autowired
    private ReseñaService reseñaService;

    @Autowired
    private ReseñaRepository reseñaRepository;

    @MockBean
    private SolicitudRepository solicitudRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    private Solicitud solicitud;
    private String estado;
    private Servicio servicio;
    private Usuario clientePrueba;

    @Before
    public void init() throws Exception{
        clientePrueba = usuarioRepository.findById(new Long(12)).get();
        servicio = servicioRepository.findById(new Long(3)).get();
        solicitud = solicitudService.solicitar(new Solicitud(servicio, clientePrueba, "Deseo solicitar su servicio", "Solicitado", 20.5, LocalDate.of(2020, 10, 20), LocalTime.of(9, 30), LocalDate.of(2020, 10, 20), null));
    }

    @Test
    public void actualizarEstadoSolicitud() throws Exception{
        estado = "Iniciado";

        assertEquals("Solicitado" , solicitud.getEstado());
    }

    @Test
    public void reseñarServicioFinalizado() throws Exception{
        estado = "Finalizado";
        Reseña reseña = new Reseña("Nunca te solicite xd", 4.0);
        reseñaService.publicarReseña(reseña, clientePrueba.getId(), servicio.getId());
        assertEquals(reseña, reseñaRepository.findByContenido("Nunca te solicite xd"));
    }


}
