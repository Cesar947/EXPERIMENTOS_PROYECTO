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
@Table(name="inconveniente")
public class Inconveniente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "inconveniente_id")
    private Long id;

    @Column(name= "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name= "cita_id")
    private Cita cita;
}
