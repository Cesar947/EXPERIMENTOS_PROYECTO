package com.myorg.ezdeal.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="membresia")
public class Membresia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "membresia_id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name="costo")
    private BigDecimal costo; //Money(?

}
