package com.myorg.ezdeal.payload.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class SignUpRequest {

    @NotBlank
    @Size(min=5, max=25)
    private String nombreUsuario;

    @NotBlank
    @Size(min=8, max=50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max=25)
    private String contrasena;
}
