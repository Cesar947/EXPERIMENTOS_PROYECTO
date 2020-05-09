package com.myorg.ezdeal;



import com.myorg.ezdeal.models.*;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;

import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureTestEntityManager
public class ReseñaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReseñaRepository reseñaRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    private Servicio servicio;


    @Before
    public void init(){
            System.out.println("Iniciamos la prueba");
            servicio = servicioRepository.findById(new Long(1)).get();

    }

    @Test
    public void validarPorcentajeReseñasNegativas(){
        List<Reseña> reseñas = this.reseñaRepository.listarReseñasPorServicio(new Long(1));
        double cantidadTotal = reseñas.size();
        double cantidadNegativas = 0;
        for(Reseña r : reseñas){
            if (r.getValoracion() < 2.5){
                cantidadNegativas++;
            }
        }
        boolean paraInhabilitar = false;
        if(cantidadTotal >= 7) {
            double porcentaje = (cantidadNegativas / cantidadTotal) * 100;
            if (porcentaje >= 75.00) {
                paraInhabilitar = true;
            }
        }
        assertTrue(paraInhabilitar);
    }


    @Test
    public void saveTest() throws Exception{
        String contenido = "Tu servicio es pésimo";
        Reseña reseña = this.entityManager.persist(new Reseña(contenido, 0, servicio, new Usuario("jose", "pinillos", "zenteno", "lima", "san miguel", "jr maypu 137", "lima", new Cuenta(), null, "imagen")));
        Reseña r2 = this.reseñaRepository.findById(reseña.getId()).get();
        assertEquals(reseña.getId(), r2.getId());
        this.entityManager.refresh(servicio);
        assertEquals(false, servicio.getEstaHabilitado());
}


    @After
    public void mensajeFinal(){
        System.out.println("Lo logró señor");
    }

}
