package com.myorg.ezdeal;



import com.myorg.ezdeal.models.*;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

import java.util.*;

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

    private Servicio servicio;


    @Before
    public void init(){
            System.out.println("Iniciamos la prueba");
            servicio = servicioRepository.findById(new Long(1)).get();

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
