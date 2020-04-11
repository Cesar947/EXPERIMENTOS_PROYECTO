package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.*;
import com.myorg.ezdeal.payload.request.JwtResponse;
import com.myorg.ezdeal.payload.request.LoginRequest;
import com.myorg.ezdeal.payload.request.MessageResponse;
import com.myorg.ezdeal.payload.request.SignUpRequest;
import com.myorg.ezdeal.repository.CuentaRepository;
import com.myorg.ezdeal.repository.RolRepository;
import com.myorg.ezdeal.repository.UsuarioRepository;
import com.myorg.ezdeal.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/login")
    public ResponseEntity<?> loginCuenta(@Valid @RequestBody LoginRequest loginRequest){

        Cuenta userDetails = cuentaRepository.findByNombreUsuario(loginRequest.getNombreUsuario());

<<<<<<< HEAD
        return ResponseEntity.ok(new Cuenta(loginRequest.getNombreUsuario(), loginRequest.getContrasena()));
=======
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
    public ResponseEntity<?> registrarCuenta(@Valid @RequestBody SignUpRequest signUpRequest){
        if(cuentaRepository.existsByNombreUsuario(signUpRequest.getNombreUsuario())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Este nombre de usuario ya esta tomado!"));
        }

        if(cuentaRepository.existsByEmail(signUpRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Este Email ya esta en uso!"));
        }

        Cuenta cuenta = new Cuenta(signUpRequest.getNombreUsuario(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getContrasena()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Rol> roles = new HashSet<>();

        if (strRoles == null) {
            Rol userRole = rolRepository.findByNombre(ERole.ROL_CLIENTE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Rol adminRole = rolRepository.findByNombre(ERole.ROL_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "anunciante":
                        Rol modRole = rolRepository.findByNombre(ERole.ROL_ANUNCIANTE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;

                    case "cliente" :
                        Rol userRole = rolRepository.findByNombre(ERole.ROL_CLIENTE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }


        cuenta.setRoles(roles);

        cuentaRepository.save(cuenta);

        Usuario usuario = new Usuario(signUpRequest.getNombres(), signUpRequest.getApellidoPaterno()
                ,signUpRequest.getApellidoMaterno(),signUpRequest.getDepartamento(), signUpRequest.getDistrito()
                , signUpRequest.getDireccion(), signUpRequest.getProvincia(), cuenta);

        usuarioRepository.save(usuario);

        return ResponseEntity.ok(new MessageResponse("Usuario Registrado!"+cuenta.getRoles()));

    }




}
