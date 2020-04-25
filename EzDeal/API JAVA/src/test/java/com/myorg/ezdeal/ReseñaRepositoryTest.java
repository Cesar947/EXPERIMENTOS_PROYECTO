package com.myorg.ezdeal;


import com.myorg.ezdeal.models.*;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest(classes = {Application.class})
public class ReseñaRepositoryTest {


    @Autowired
    private ReseñaRepository resenaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ServicioRepository servicioRepository;


    @Test
    @Transactional
    public void saveTest() throws Exception{
        String contenido = "Tu servicio apesta";
        Long anuncianteId = new Long(1);
        Long servicioId = new Long(1);
        Reseña r = this.resenaRepository.save(new Reseña(contenido, 2, servicioRepository.findById(servicioId).get(),
                usuarioRepository.findById(anuncianteId).get()));
                /*new Usuario("César Alejandro", "Perez", "Llanos", "lima", "Magdalena del Mar", "Av. Zucre 333", "lima",
                        new Cuenta(new Long(1), "2345678", "cpizanos@gmail.com","Cesar947", roles), null, "qgWjsyendiAdnw.jpg")*/
        Reseña reseña = this.resenaRepository.findByContenido(contenido);
        assertEquals(r.getContenido(), reseña.getContenido());

    }


}