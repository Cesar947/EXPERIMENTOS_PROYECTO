package com.myorg.ezdeal.service.Implementation;

import com.myorg.ezdeal.models.Cuenta;
import com.myorg.ezdeal.models.CuentaPrincipal;
import com.myorg.ezdeal.models.Rol;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CuentaServiceImpl implements UserDetailsService {

    @Autowired
    CuentaRepository cuentaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cuenta user = cuentaRepository.findByNombreUsuario(username);

        return new CuentaPrincipal(user);
    }
}
