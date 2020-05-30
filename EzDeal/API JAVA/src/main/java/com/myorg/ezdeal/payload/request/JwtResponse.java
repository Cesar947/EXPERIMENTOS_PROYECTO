package com.myorg.ezdeal.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {

    private String token;

    private String type;

    private Long id;

    private Long usuarioId;

    private String nombreUsuario;

    private String email;

    private List<String> roles;

    public JwtResponse(String token, Long id, Long usuarioId, String nombreUsuario, String email, List<String> roles){
        this.token =token;
        this.id=id;
        this.nombreUsuario=nombreUsuario;
        this.email=email;
        this.roles=roles;
        this.usuarioId = usuarioId;
    }

}
