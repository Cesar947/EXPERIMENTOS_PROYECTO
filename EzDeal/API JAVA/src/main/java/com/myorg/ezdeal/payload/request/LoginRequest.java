package com.myorg.ezdeal.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {

    @NotBlank
    @Size(min=5, max=25)
    private String nombreUsuario;

    @NotBlank
    @Size(min=6, max=25)
    private String contrasena;
}
