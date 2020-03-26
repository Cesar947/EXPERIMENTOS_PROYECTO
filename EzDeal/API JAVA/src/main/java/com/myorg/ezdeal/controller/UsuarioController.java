package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(path="/cliente", method = RequestMethod.POST)
    public Usuario registrarCliente(@RequestBody Usuario usuario) throws Exception{

        usuario.setRol('C');
        return this.usuarioService.registrarUsuario(usuario);
    }

    @GetMapping("/")
    public String HolaMundo(){
        return "Hola Mundo";
    }
}
