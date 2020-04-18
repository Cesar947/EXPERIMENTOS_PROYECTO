package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Anunciante;
import com.myorg.ezdeal.repository.AnuncianteRepository;
import com.myorg.ezdeal.service.AnuncianteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AnuncianteServiceImpl implements AnuncianteService {


    private AnuncianteRepository anuncianteRepository;

    @Autowired
    public AnuncianteServiceImpl(AnuncianteRepository anuncianteRepository){
        this.anuncianteRepository = anuncianteRepository;
    }

    @Transactional
    public Anunciante guardarDatosAnunciante(Anunciante anunciante) throws Exception{
          return this.anuncianteRepository.save(anunciante);
    }

}
