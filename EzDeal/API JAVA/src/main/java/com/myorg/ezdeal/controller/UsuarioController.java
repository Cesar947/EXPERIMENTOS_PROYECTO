package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Slf4j /*Para usar el comando log*/
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(final UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() throws Exception{
         return this.usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario verPerfil(final @PathVariable Long id) throws Exception{
        return this.usuarioService.verPerfil(id);
    }

    @PutMapping
    public int actualizarMembresia(@RequestParam("membresia") String nombreMembresia, @RequestParam("usuarioId") Long usuarioId) throws Exception{
        return this.usuarioService.actualizarMembresia(nombreMembresia, usuarioId);
    }

    @GetMapping("/{id}/membresia")
    public String obtenerNombreMembresia(final @PathVariable Long id) throws Exception{
            return this.usuarioService.obtenerNombreMembresia(id);
    }

}
