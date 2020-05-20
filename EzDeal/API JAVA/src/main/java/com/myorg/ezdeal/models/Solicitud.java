package com.myorg.ezdeal.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="solicitud")
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="solicitud_id")
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="servicio_id")
    private Servicio servicio;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private Usuario cliente;

    @Column(name="mensaje")
    private String mensaje;

    // Enviada - Aceptada - Rechazada
    @Column(name="estado")
    private String estado;

    @Column(name="fecha_solicitud")
    private LocalDate fechaSolicitud;

    @Column(name="hora_pactada", nullable=true)
    private LocalTime horaPactada;

    @Column(name="fecha_pactada", nullable=true)
    private LocalDate fechaPactada;

    @Column(name="hora_fin")
    private LocalTime horaFinEstimada;

    public Solicitud(Servicio servicio, Usuario cliente, String mensaje, String estado, LocalDate fechaSolicitud, LocalTime horaPactada, LocalDate fechaPactada) {
        this.servicio = servicio;
        this.cliente = cliente;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaPactada = fechaPactada;
        this.horaPactada = horaPactada;
    }
}
