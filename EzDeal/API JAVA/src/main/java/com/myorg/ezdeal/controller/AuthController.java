package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.Cuenta;
import com.myorg.ezdeal.models.Rol;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.payload.request.LoginRequest;
import com.myorg.ezdeal.payload.request.SignUpRequest;
import com.myorg.ezdeal.repository.CuentaRepository;
import com.myorg.ezdeal.repository.RolRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/login")
    public ResponseEntity<Usuario> loginCuenta(@Valid @RequestBody LoginRequest loginRequest){

        Cuenta cuenta = cuentaRepository.findByNombreUsuarioAndContrasena(loginRequest.getNombreUsuario(), loginRequest.getContrasena());
        return ResponseEntity.ok(usuarioRepository.getByCuentaId(cuenta));
    }

    @PostMapping("/registro")
    public ResponseEntity<Cuenta> registrarCuenta(@Valid @RequestBody SignUpRequest signUpRequest, @RequestParam("rol") String rol){
        if(cuentaRepository.existsByNombreUsuario(signUpRequest.getNombreUsuario())){

        }

        if(cuentaRepository.existsByEmail(signUpRequest.getEmail())){

        }

        Cuenta cuenta = new Cuenta(signUpRequest.getNombreUsuario(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getContrasena()));

        Set<Rol> roles = new HashSet<>();


        Optional<Rol> cuentaRol = rolRepository.findByNombre(rol);
        if(!cuentaRol.isPresent()){

        }

        roles.add(cuentaRol.get());

        cuenta.setRoles(roles);

        cuentaRepository.save(cuenta);

        Usuario usuario = new Usuario(signUpRequest.getNombres(), signUpRequest.getApellidoPaterno()
                ,signUpRequest.getApellidoMaterno(),signUpRequest.getDepartamento(), signUpRequest.getDistrito()
                , signUpRequest.getDireccion(), signUpRequest.getProvincia(), cuenta);

        usuarioRepository.save(usuario);

        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.CREATED);

    }




}