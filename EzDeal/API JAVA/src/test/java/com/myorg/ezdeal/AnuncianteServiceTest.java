package com.myorg.ezdeal;

import com.myorg.ezdeal.models.Anunciante;
import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.service.AnuncianteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnuncianteServiceTest {


    @Autowired
    AnuncianteService anuncianteService;

    @Test
    @Transactional
    public void testActualizarMembresia() throws Exception{
        int membresiaActualizada = anuncianteService.actualizarDatosMembresia("GOLD", Long.valueOf(1));
        assertEquals(1,  membresiaActualizada);
    }


    @Test
    @Transactional
    public void testGuardarDatosAnunciante() throws Exception{
        /**/
        Anunciante infoAnunciante = anuncianteService.guardarDatosAnunciante(
              new Anunciante("7777777",
                      "999999999",
                      "75637222",
                      "www.facebook.com/C",
                      "antecedentes.pdf", LocalDate.of(2020, 06, 10), new Membresia("GOLD", BigDecimal.valueOf(18.99)))
        );
        assertNotNull(infoAnunciante);


    }
}
