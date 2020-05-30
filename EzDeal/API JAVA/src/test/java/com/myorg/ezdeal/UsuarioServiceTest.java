package com.myorg.ezdeal;

import com.myorg.ezdeal.models.Anunciante;
import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {


    @Autowired
    UsuarioService usuarioService;

    @Test
    @Transactional
    public void testActualizarMembresia() throws Exception{
        int membresiaActualizada = usuarioService.actualizarMembresia("GOLD", Long.valueOf(1));
        assertEquals(1,  membresiaActualizada);
    }

}
