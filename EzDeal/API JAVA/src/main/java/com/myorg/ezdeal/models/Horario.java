package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;

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
    private Time horaApertura;

    @Column(name="hora_cierre")
    private Time horaCierre;

    @ManyToOne
    @JoinColumn(name="servicio_id")
    private Servicio servicio;


}
