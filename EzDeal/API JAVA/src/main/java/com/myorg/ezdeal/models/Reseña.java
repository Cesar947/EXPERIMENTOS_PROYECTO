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
@Table(name="reseña")
public class Reseña implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reseña_id")
    private Long id;

    @Column(name="contenido")
    private String contenido;

    @Column(name="valoracion")
    private double valoracion;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="servicio_id")
    private Servicio servicio;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private Usuario cliente;

    public Reseña(String contenido, double valoracion, Servicio servicio, Usuario cliente) {
        this.contenido = contenido;
        this.valoracion = valoracion;
        this.servicio = servicio;
        this.cliente = cliente;
    }


    public Reseña(String contenido, double valoracion){

        this.contenido = contenido;
        this.valoracion = valoracion;
    }
}
