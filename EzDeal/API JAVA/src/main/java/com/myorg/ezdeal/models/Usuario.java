package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "usuario_id", nullable = false)
    private Long id;

    @Column(name="nombres", nullable = false)
    private String nombres;

    @Column(name="apellido_paterno", nullable = false)
    private String apellidoPaterno;

    @Column(name="apellido_materno", nullable = false)
    private String apellidoMaterno;

    @Column(name="departamento", nullable = false)
    private String departamento;

    @Column(name="distrito", nullable = false)
    private String distrito;

    @Column(name="direccion", nullable = false)
    private String direccion;

    @Column(name="provincia", nullable = false)
    private String provincia;

    @Column(name="strikes")
    private Integer strikes;

    @Column(name="cuenta_habilitada")
    private Boolean cuentaHabilitada;

    @Column(name="imagen_perfil")
    private String imagenPerfil;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cuenta_id", nullable = false)
    private Cuenta cuentaId;

    @OneToOne
    @JoinColumn(name="anunciante_id")
    private Anunciante infoAnunciante;

    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String departamento, String distrito, String direccion, String provincia, Cuenta cuentaId, Anunciante infoAnunciante, String imagenPerfil) {

        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.departamento =departamento;
        this.distrito = distrito;
        this.direccion = direccion;
        this.provincia = provincia;
        this.cuentaId = cuentaId;

        this.infoAnunciante = infoAnunciante;
        this.imagenPerfil = imagenPerfil;

    }


}
