package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="horario")
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="horario_id")
    private Integer id;

    @Column(name="dia")
    private String dia;

    @Column(name="hora_apertura")
    private LocalTime horaApertura;

    @Column(name="hora_cierre")
    private LocalTime horaCierre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="servicio_id")
    private Servicio servicio;


}
