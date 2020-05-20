package com.myorg.ezdeal.models;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cita")
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cita_id")
    private Long id;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Column(name="costo_final")
    private BigDecimal costoFinal;

    @Column(name = "estado")
    private String estado;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="solicitud_id", nullable = false)
    private Solicitud solicitud;


}
