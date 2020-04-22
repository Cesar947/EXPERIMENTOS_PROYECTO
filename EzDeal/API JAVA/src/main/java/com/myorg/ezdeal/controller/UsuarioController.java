package com.myorg.ezdeal.controller;


import com.myorg.ezdeal.models.CuentaPrincipal;
import com.myorg.ezdeal.models.Usuario;
import com.myorg.ezdeal.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/hola-mundo")
    public String HolaMundo(){
        log.info("Ejecutando");
        return "Hola Mundo";
    }

    @GetMapping("/")
    public List<Usuario> listarUsuarios() throws Exception{
         return this.usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarios(@PathVariable Long id) throws Exception{
        return this.usuarioService.verPerfil(id);
    }

    @GetMapping("/prueba")
    @Secured({ "ROL_CLIENTE" })
    public String Home(){
        return "Home";
    }

   /* @GetMapping("/ver-cuenta")
   public Long getIdCuenta(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CuentaPrincipal userDetails = (CuentaPrincipal) authentication.getPrincipal();
        return userDetails.getId();
    }
*/
   @GetMapping("/quieroverelID")
   public Long obtenerID() throws Exception{

       return getCurrentUserId();
   }
    public static Long getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String id = null;
        if (authentication != null)
                log.info("****************************");
                log.info(((UserDetails) authentication.getPrincipal()).getUsername());
                log.info("****************************");
                id = ((UserDetails) authentication.getPrincipal()).getUsername();
        try {
            return Long.valueOf(id != null ? id : "0"); //anonymoususer
        } catch (NumberFormatException e) {
            return 1L;
        }
    }
}
