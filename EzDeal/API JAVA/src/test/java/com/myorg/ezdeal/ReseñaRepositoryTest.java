package com.myorg.ezdeal;


import com.myorg.ezdeal.models.Reseña;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.ReseñaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReseñaRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReseñaRepository reseñaRepository;

    @Test

    public void saveTest() throws Exception{
        String contenido = "Tu servicio apesta";
        this.entityManager.persist(new Reseña(contenido,
                2, new Servicio(), new Usuario()));
        Reseña reseña = this.reseñaRepository.findByContenido(contenido);
        assertEquals(reseña.getContenido(), contenido);

    }


}
