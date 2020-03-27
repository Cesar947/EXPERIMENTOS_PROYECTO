package com.myorg.ezdeal.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="inconveniente")
public class Incoveniente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inconveniente_id")
    private Integer id;


    @Column(name="descripción")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="anunciante_id")
    private Usuario anunciante;

    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;



}
