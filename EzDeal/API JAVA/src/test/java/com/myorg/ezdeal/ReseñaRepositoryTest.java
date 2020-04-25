package com.myorg.ezdeal;


import com.myorg.ezdeal.models.Cuenta;
import com.myorg.ezdeal.models.Reseña;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;


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
    @Test
    public void saveTest() throws Exception{
        String contenido = "Tu servicio apesta";
        Servicio servicio = servicioRepository.findById(new Long(4)).get();
        this.entityManager.persist(new Reseña(contenido, 2, servicio, new Usuario("jose", "pinillos", "zenteno", "lima", "san miguel", "jr maypu 137", "lima", new Cuenta(), null, "imagen")));
        this.entityManager.flush();
        this.entityManager.refresh(servicio);
        assertEquals(false, servicio.getEstaHabilitado());

    }

}
