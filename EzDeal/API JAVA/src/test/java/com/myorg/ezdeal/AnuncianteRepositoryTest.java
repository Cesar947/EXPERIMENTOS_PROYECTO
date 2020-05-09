package com.myorg.ezdeal;

import com.myorg.ezdeal.models.Anunciante;
import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.repository.AnuncianteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnuncianteRepositoryTest {

    @Autowired
    private AnuncianteRepository anuncianteRepository;

    @Before
    public void inicioDePrueba(){
        System.out.println("Iniciamos la prueba de anunciante repository");
    }


    /*
    Test para verificar que se actualize correctamente la membresía de un Anunciante
    y que esta membresía sea la esperada
     */
    @Test
    @Transactional
    public void actualizarMembresiaTest(){
        Membresia memb = getMembresiaGold();
        Long anuncianteId = Long.valueOf(1);
        int membresiaActualizada1 = anuncianteRepository.actualizarDatosMembresia(memb, anuncianteId);
        Anunciante anunciante = anuncianteRepository.findById(anuncianteId).get();
        assertEquals(1, membresiaActualizada1);
        assertEquals("GOLD", anunciante.getMembresia().getNombre());

    }

    public Membresia getMembresiaGold(){
        return new Membresia(Long.valueOf(1), "GOLD", new BigDecimal(60.0));
    }

}
