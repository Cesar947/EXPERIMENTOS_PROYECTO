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
@Table(name="tipo_servicio")
public class TipoServicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tipo_servicio_id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

}
