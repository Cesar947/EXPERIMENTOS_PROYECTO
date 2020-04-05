package com.myorg.ezdeal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "rol_id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private Set<Cuenta> cuentas;
}
