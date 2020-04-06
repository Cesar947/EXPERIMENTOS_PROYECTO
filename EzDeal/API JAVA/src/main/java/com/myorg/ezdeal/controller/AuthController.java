package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.Cuenta;
import com.myorg.ezdeal.models.CuentaPrincipal;
import com.myorg.ezdeal.models.Rol;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.payload.request.JwtResponse;
import com.myorg.ezdeal.payload.request.LoginRequest;
import com.myorg.ezdeal.payload.request.SignUpRequest;
import com.myorg.ezdeal.repository.CuentaRepository;
import com.myorg.ezdeal.repository.RolRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
<<<<<<< HEAD
import com.myorg.ezdeal.service.Implementation.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
=======
import com.myorg.ezdeal.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
>>>>>>> master
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

<<<<<<< HEAD
    @GetMapping("/login")
    public ResponseEntity<UserDetails> loginCuenta(@Valid @RequestBody LoginRequest loginRequest){

        UserDetails cuenta = cuentaService.loadUserByUsername(loginRequest.getNombreUsuario());

        return ResponseEntity.ok(cuenta);
=======
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> loginCuenta(@Valid @RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getNombreUsuario(), loginRequest.getContrasena()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        CuentaPrincipal userDetails = (CuentaPrincipal) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
>>>>>>> master
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
