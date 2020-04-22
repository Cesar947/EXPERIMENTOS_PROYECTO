package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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

    @Column(name="apellido_paterno")
    private String apellidoPaterno;

    @Column(name="apellido_materno")
    private String apellidoMaterno;

    @Column(name="departamento")
    private String departamento;

    @Column(name="distrito")
    private String distrito;

    @Column(name="direccion")
    private String direccion;

    @Column(name="provincia")
    private String provincia;

    @Column(name="strikes")
    private Integer strikes;

    @Column(name="cuenta_habilitada")
    private Boolean cuentaHabilitada;

    @Column(name="imagen_perfil")
    private String imagenPerfil;

    @OneToOne
    @JoinColumn(name="cuenta_id", nullable = false)
    private Cuenta cuentaId;

    @OneToOne
    @JoinColumn(name="anunciante_id")
    private Anunciante infoAnunciante;

<<<<<<< HEAD
    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String departamento, String distrito, String direccion, String provincia, Cuenta cuentaId, Anunciante anunciante) {
=======
    public Usuario(String nombres, String apellidoPaterno, String apellidoMaterno, String departamento, String distrito, String direccion, String provincia, Cuenta cuentaId, Anunciante infoAnunciante, String imagenPerfil) {
>>>>>>> master
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.departamento =departamento;
        this.distrito = distrito;
        this.direccion = direccion;
        this.provincia = provincia;
        this.cuentaId = cuentaId;
<<<<<<< HEAD
        this.infoAnunciante = anunciante;
=======
        this.infoAnunciante = infoAnunciante;
        this.imagenPerfil = imagenPerfil;
>>>>>>> master
    }


}
