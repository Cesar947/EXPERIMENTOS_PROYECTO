package com.myorg.ezdeal.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="servicio")
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "servicio_id")
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name="anunciante_id")
    private Usuario anunciante;

    @ManyToOne
    @JoinColumn(name="tipo_servicio_id")
    private TipoServicio tipoServicio;

    @Column(name="imagen")
    private String imagen; //y si queremos agregar más imagenes?

    @Column(name="costo_servicio")
    private BigDecimal costoServicio;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="esta_habilitado")
    private Boolean estaHabilitado;

    @Column(name="valoracion")
    private Double valoracion;

    @Column(name="fecha_publicacion")
    private LocalDate fechaPublicacion;

    //1:A domicilio, 2:En local, 3:A domicilio & En local
    @Column(name="modalidad")
    private Integer modalidad;

    @Column(name="video_presentacion")
    private String videoPresentacion;

    @OneToMany(mappedBy="servicio")
    private List<Horario> horarios;
}


