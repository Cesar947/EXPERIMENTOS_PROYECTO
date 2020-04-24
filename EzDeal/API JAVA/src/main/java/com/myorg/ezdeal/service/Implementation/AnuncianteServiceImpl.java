package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Anunciante;
import com.myorg.ezdeal.models.Membresia;
import com.myorg.ezdeal.repository.AnuncianteRepository;
import com.myorg.ezdeal.repository.MembresiaRepository;
import com.myorg.ezdeal.service.AnuncianteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AnuncianteServiceImpl implements AnuncianteService {


    private AnuncianteRepository anuncianteRepository;
    private MembresiaRepository membresiaRepository;


    @Autowired
    public AnuncianteServiceImpl(AnuncianteRepository anuncianteRepository, MembresiaRepository membresiaRepository){
        this.anuncianteRepository = anuncianteRepository;
        this.membresiaRepository = membresiaRepository;
    }

    @Transactional
    public Anunciante guardarDatosAnunciante(Anunciante anunciante) throws Exception{
          return this.anuncianteRepository.save(anunciante);
    }

    public int actualizarDatosMembresia(String nombreMembresia, Long anuncianteId) throws Exception {
        Membresia objMembresia = this.membresiaRepository.buscarPorNombre(nombreMembresia);
        int actualizacionExitosa = this.anuncianteRepository.actualizarDatosMembresia(objMembresia,anuncianteId);
        if (actualizacionExitosa == 1) return actualizacionExitosa;
        else return 0;


    }

}
