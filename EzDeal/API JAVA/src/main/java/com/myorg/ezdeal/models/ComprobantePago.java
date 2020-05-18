package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="comprobante_pago")
public class ComprobantePago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comprobante_id")
    private Long id;

    @Column(name="importe")
    private BigDecimal monto;

    @Column(name="igv")
    private BigDecimal igv;

    @Column(name="monto_neto")
    private BigDecimal montoNeto;

    @Column(name="fecha_pago")
    private LocalDate fechaPago;

    @Column(name="hora_pago")
    private LocalTime horaPago;

    @ManyToOne
    @JoinColumn(name="anunciante_id")
    private Anunciante anunciante;

    @Column(name="membresia_id")
    private Membresia membresia;

}
