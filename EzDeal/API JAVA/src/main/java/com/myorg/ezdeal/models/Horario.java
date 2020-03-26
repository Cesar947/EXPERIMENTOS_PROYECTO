package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="horario")
public class Horario {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="horario_id")
    private Integer id;

    @Column(name="dia")
    private String dia;

    @Column(name="hora_apertura")
    @Temporal(TemporalType.TIME)
    private Date horaApertura;

    @Column(name="hora_cierre")
    @Temporal(TemporalType.TIME)
    private Date horaCierre;

    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;


}
