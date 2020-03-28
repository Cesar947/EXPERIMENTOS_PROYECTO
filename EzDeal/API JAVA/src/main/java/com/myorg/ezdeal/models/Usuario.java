package com.myorg.ezdeal.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "usuario_id")
    private Integer id;

    @Column(name="rol")
    private char rol;

    @Column(name="email")
    private String email;

    @Column(name="contrasena")
    private String contrasena;

    @Column(name="nombres")
    private String nombres;

    @Column(name="apellidos")
    private String apellidos;

    @Column(name="telefono_fijo")
    private String telefonoFijo;

    @Column(name="celular")
    private String celular;

    @Column(name="url_contacto")
    private String urlContacto;

    @Column(name="distrito")
    private String distrito;

    @Column(name="direccion")
    private String direccion;

    @Column(name="provincia")
    private String provincia;


}
