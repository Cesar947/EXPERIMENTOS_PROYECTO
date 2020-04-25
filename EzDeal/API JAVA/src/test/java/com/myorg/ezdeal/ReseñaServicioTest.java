package com.myorg.ezdeal;

import com.myorg.ezdeal.models.Reseña;
import com.myorg.ezdeal.models.Servicio;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.ReseñaRepository;
import com.myorg.ezdeal.repository.ServicioRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.service.ReseñaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ReseñaServicioTest {

    @Mock
    private ReseñaRepository reseñaRepository;
    @Mock
    private ServicioRepository servicioRepository;
    @Mock
    private UsuarioRepository usuarioRepository;
    @InjectMocks
    private ReseñaService reseñaService;

    @Test
    void saveReseña(){
        when(servicioRepository.findById(anyLong()).get()).thenReturn(new Servicio());
        when(usuarioRepository.findById(anyLong()).get()).thenReturn(new Usuario());

    }


}
