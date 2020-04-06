package com.myorg.ezdeal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cuenta")
public class Cuenta implements Serializable {

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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "cuenta_rol",
            joinColumns = @JoinColumn(name = "cuenta_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles;

    public Cuenta(String nombreUsuario, String email, String contrasena){
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
    }
}
