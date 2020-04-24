package com.myorg.ezdeal;

import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.repository.ServicioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DataJpaTest
//Para que se reconozca el contexto de la aplicación, puesto que está en otro paquete la clase Application.java
public class ServicioRepositoryTest {

    @Autowired
    private ServicioRepository servicioRepository;


    @Before
    public void iniciarPrueba() throws Exception{
        System.out.println("Iniciamos la prueba");
    }

    @Test
    public void listarPorMembresiaYBusqueda() throws Exception{

        List<Servicio> servicios = servicioRepository.listarServiciosPorTitulo("%Servicio%");
        //Probamos si la lista de servicios no retorna null
        assertNotNull(servicios);
        if(servicios != null) {
            Membresia mem1;
            Membresia mem2;
            boolean ordenado = true;
            boolean titulosCorrectos = true;
            for (int i = 0; i < servicios.size(); i++) {
                if (i < servicios.size() - 1) {
                    mem1 = servicios.get(i).getAnunciante().getInfoAnunciante().getMembresia();
                    mem2 = servicios.get(i + 1).getAnunciante().getInfoAnunciante().getMembresia();
                    //Probando que el ordenamiento por membresía es correcto
                    if (mem1.getNombre().equals("GRATUITA") && mem2.getNombre().equals("GOLD")) {
                        ordenado = false;
                    }
                }
                //Probando que la búsqueda por cadena es correcta
                if (!servicios.get(i).getTitulo().contains("Servicio")) {
                    titulosCorrectos = false;
                }
            }

            assertEquals(true, ordenado);
            assertEquals(true, titulosCorrectos);
        }


    }
}
