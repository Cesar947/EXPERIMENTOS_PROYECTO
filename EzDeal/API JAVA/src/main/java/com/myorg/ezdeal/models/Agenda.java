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
@Table(name="agenda")
//Agenda se encarga de registrar la hora y fecha pactada por el cliente y el anunciante
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agenda_id")
    private Long id;

    @Column(name="dia")
    private String dia;

    @Column(name="hora_inicio")
    private LocalDate horaInicio;

    @Column(name="hora_fin")
    private LocalDate horaFin;

    @ManyToOne
    @JoinColumn(name="solicitud_id")
    private Solicitud solicitud;
}
