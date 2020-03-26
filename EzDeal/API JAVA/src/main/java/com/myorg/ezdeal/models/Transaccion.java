package com.myorg.ezdeal.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transaccion")
public class Transaccion {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="solicitud_id")
    private Integer id;

    @ManyToOne
    @Column(name="servicio_id")
    private Servicio servicio;

    @ManyToOne
    @Column(name="cliente_ id")
    private Usuario cliente;

    @Column(name="mensaje")
    private String mensaje;

    @Column(name="estado")
    private String estado;

    @Column(name="costo_final")
    private double costoFinal;

}
