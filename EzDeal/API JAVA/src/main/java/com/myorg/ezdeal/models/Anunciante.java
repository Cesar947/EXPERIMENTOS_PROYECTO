package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="anunciante")
public class Anunciante {

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
}
