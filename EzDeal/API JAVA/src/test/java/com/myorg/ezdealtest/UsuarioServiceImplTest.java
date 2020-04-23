package com.myorg.ezdealtest;


import com.myorg.ezdeal.models.Cuenta;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.Implementation.UsuarioServiceImpl;
import com.myorg.ezdeal.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsuarioServiceImpl.class)
public class UsuarioServiceImplTest {

    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    public void listarUsuariosTest(){
        when(usuarioRepository.findAll()).thenReturn(
               Stream.of(new Usuario("César", "Pizarro", "Llanos", "Lima",
                        "Magdalena del Mar", "Av. Sucre 133", "Lima",
                        new Cuenta("cesar947", "cpizarrollanos@gmail.com", "3456789"),
                        null, "sadgsdgsadg.jpg")).collect(Collectors.toList()));
       try {
           assertEquals(1, usuarioService.listarUsuarios().size());
       }
       catch(Exception e){

       }
    }

}