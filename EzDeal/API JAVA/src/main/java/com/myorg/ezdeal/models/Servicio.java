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
@Table(name="servicio")
public class Servicio {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "anuncio_id")
    private Integer id;

    @Column(name="titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name="anunciante_id")
    private Usuario anunciante;

    @ManyToOne
    @JoinColumn(name="tipo_servicio_id")
    private TipoServicio tipoServicio;

    @Column(name="imagen")
    private String imagen;

    @Column(name="valor_servicio")
    private double valorServicio;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="esta_habilitado")
    private String estaHabilitado;

    @Column(name="valoracion")
    private double valoracion;

    @Column(name="fecha_publicacion")
    private LocalDate fechaPublicacion;

    @Column(name="disponible_express")
    private boolean disponibleExpress;


}


