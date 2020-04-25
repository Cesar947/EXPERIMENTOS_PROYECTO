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

/*

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

    public Usuario getCliente(){

        return new Usuario(new Long(3),"Sebastian", "Pinillos","Zenteno",
                "Lima", "San Miguel",  "Jr. Maypu 137","Lima", 0, true,
                "asdfsadgadsg.jpg", getCuenta().get(0), null);
    }

    public List<Cuenta> getCuenta(){
        List<Cuenta> cuentas = new ArrayList<>();
        Rol rolCliente = new Rol(new Long(1),ERole.ROL_CLIENTE);
        Set<Rol> roles1 = new HashSet<>();
        roles1.add(rolCliente);
        cuentas.add(new Cuenta(new Long(3),"pepino","sebastian@gmail.com", "1234567", roles1));

        Rol rolAnunciante = new Rol(new Long(1),ERole.ROL_ANUNCIANTE);
        Set<Rol> roles2 = new HashSet<>();
        roles2.add(rolCliente);
        roles2.add(rolAnunciante);
        cuentas.add(new Cuenta(new Long(1),"pepino","sebastian@gmail.com", "1234567", roles1));

        return cuentas;

    }

    public Servicio Servicio(){

        return new Servicio();
    }

    public Usuario getAnunciante(){

        return new Usuario();
    }

}
*/
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
