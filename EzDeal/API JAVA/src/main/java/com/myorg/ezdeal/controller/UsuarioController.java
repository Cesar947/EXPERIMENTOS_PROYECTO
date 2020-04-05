package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth/usuarios")
@Slf4j /*Para usar el comando log*/
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(path="/cliente", method = RequestMethod.POST)
    public Usuario registrarCliente(@RequestBody Usuario usuario) throws Exception{

        //usuario.setRol('C');
        return this.usuarioService.registrarUsuario(usuario);
    }

    @RequestMapping(path="/anunciante", method = RequestMethod.POST)
    public Usuario registrarAnunciante(@RequestBody Usuario usuario) throws Exception{

        //usuario.setRol('A');
        return this.usuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/")
    public String HolaMundo(){
        log.info("Ejecutando");
        return "Hola Mundo";
    }

    @GetMapping("/ver-usuarios")
    public List<Usuario> listarUsuarios() throws Exception{
         return this.usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarios(@PathVariable Integer id) throws Exception{
        return this.usuarioService.verPerfil(id);
    }

}
