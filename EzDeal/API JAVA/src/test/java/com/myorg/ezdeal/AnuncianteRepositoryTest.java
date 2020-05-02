package com.myorg.ezdeal;

import com.myorg.ezdeal.models.Anunciante;
import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.repository.AnuncianteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnuncianteRepositoryTest {

    @Autowired
    private AnuncianteRepository anuncianteRepository;

    @Before
    public void inicioDePrueba(){
        System.out.println("Iniciamos la prueba de anunciante repository");
    }

    @Test
    @Transactional
    public void actualizarMembresiaTest(){
        Membresia memb = getMembresiaGold();
        Long anuncianteId = new Long(1);
        int membresiaActualizada1 = anuncianteRepository.actualizarDatosMembresia(memb, anuncianteId);
        Anunciante anunciante = anuncianteRepository.findById(anuncianteId).get();
        assertEquals(1, membresiaActualizada1);
        assertEquals("GOLD", anunciante.getMembresia().getNombre());

    }

    public Membresia getMembresiaGold(){
        return new Membresia(new Long(1), "GOLD", new BigDecimal(60.0));
    }

}
