package com.myorg.ezdeal;

import com.myorg.ezdeal.repository.AnuncianteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DataJpaTest
public class AnuncianteRepositoryTest {

    @Autowired
    private AnuncianteRepository anuncianteRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void inicioDePrueba(){
        System.out.println("Iniciamos la prueba de anunciante repository");
    }

    @Test
    public void actualizarMembresiaTest(){



    }


}
