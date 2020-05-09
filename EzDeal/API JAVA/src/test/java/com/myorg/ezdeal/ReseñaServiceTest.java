package com.myorg.ezdeal;

import com.myorg.ezdeal.models.Reseña;
import com.myorg.ezdeal.service.ReseñaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReseñaServiceTest {

    @Autowired
    private ReseñaService reseñaService;

    @Test
    public void testGuardarReseñaConSolicitudFinalizada() throws Exception{

        Reseña reseñaGuardada = reseñaService.publicarReseña(new Reseña("Eres pésimo", 0.5), Long.valueOf(2), Long.valueOf(1));
        boolean guardado = false;
        if(reseñaGuardada.getContenido() != ""){
            guardado = true;
        }
        assertTrue(guardado);

    }






}
