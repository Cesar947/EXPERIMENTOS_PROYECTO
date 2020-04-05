package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cuenta")
public class Cuenta {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "cuenta_id")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="contrasena")
    private String contrasena;

    @Column(name="nombre_usuario")
    private String nombreUsuario;

    @Column(name="rol")
    private String rol;
}
