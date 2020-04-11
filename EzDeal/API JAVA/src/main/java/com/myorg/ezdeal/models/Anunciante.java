package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="anunciante")
public class Anunciante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "anunciante_id")
    private Long id;

    @Column(name="telefono_fijo")
    private String telefonoFijo;

    @Column(name="celular")
    private String celular;

    @Column(name="dni")
    private String dni;

    @Column(name="url_contacto")
    private String urlContacto;

    @Column(name="antecedentes_penales")
    private String antecedentesPenales;

    @Column(name="fecha_caducidad")
    private LocalDate fechaCaducidad;

    @ManyToOne
    @JoinColumn(name="membresia_id")
    private Membresia membresia;

    public Anunciante(String telefonoFijo, String celular, String dni, String urlContacto, String antecedentesPenales){
        this.telefonoFijo = telefonoFijo;
        this.celular = celular;
        this.dni = dni;
        this.urlContacto = urlContacto;
        this.antecedentesPenales = antecedentesPenales;

    }
}
