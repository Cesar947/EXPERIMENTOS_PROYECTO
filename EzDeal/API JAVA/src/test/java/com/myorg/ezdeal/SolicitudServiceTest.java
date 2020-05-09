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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
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

    @Test
    @Transactional
    public void reseñarServicioFinalizado() throws Exception{

        this.estado = "Inciado";
        String estado1 = "Finalizado";
        Long solicitudId = new Long(1);

        //Esta prueba esta hecha para fallar
        solicitudService.actualizarEstadoSolicitud(estado, solicitudId);
        Reseña reseña = new Reseña("Nunca te solicite", 4.0);
        Reseña reseñaGuardada = reseñaService.publicarReseña(reseña, clientePrueba.getId(), servicio.getId());
        //Probamos que nunca se guarda la reseña
        assertEquals(new Reseña(), reseñaGuardada);

        //Esta prueba esta hecha para aprobar
        solicitudService.actualizarEstadoSolicitud(estado1, solicitudId);
        solicitudRepository.actualizarEstadoSolicitud(estado1, solicitudId);
        reseñaGuardada = reseñaService.publicarReseña(reseña, clientePrueba.getId(), servicio.getId());
        Reseña reseñaPrueba = reseñaRepository.findById(reseñaGuardada.getId()).get();
        //Probamos que la reseña si se guarda porque ahora si existe una solicitud finalizada
        assertEquals(reseñaGuardada, reseñaPrueba);
    }


    @Test
    @Transactional
    public void reseñarServicioFinalizadov2() throws Exception{


        //Mockeamos el solicitudservice

        //No se si funciona con el size, de lo contrario probarlo sin el
        when(solicitudService.listarPorClienteYServicio(anyLong(), anyLong()).size()).thenReturn(1);


        Reseña reseña = new Reseña("Nunca te solicite", 4.0);

        int cantidadDeSolicitudesFinalizadas = solicitudService.listarPorClienteYServicio(clientePrueba.getId(), servicio.getId()).size();

        Reseña reseñaResultado = new Reseña();

        if(cantidadDeSolicitudesFinalizadas > 0) {

            reseña.setCliente(clientePrueba);
            reseña.setServicio(servicio);

            reseñaResultado = reseñaRepository.save(reseña);
        }

        assertEquals(reseñaResultado, reseña);

    }

}