package com.myorg.ezdeal.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="servicio")
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "servicio_id")
    private Long id;

    @Column(name="titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name="anunciante_id")
    private Usuario anunciante;

    @ManyToOne
    @JoinColumn(name="tipo_servicio_id")
    private TipoServicio tipoServicio;

    @Column(name="imagen")
    private String imagen; //y si queremos agregar más imagenes?

    @Column(name="costo_servicio")
    private BigDecimal costoServicio;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="esta_habilitado")
    private Boolean estaHabilitado;

    @Column(name="valoracion")
    private Double valoracion;

    @Column(name="fecha_publicacion")
    private LocalDate fechaPublicacion;

    //1:A domicilio, 2:En local, 3:A domicilio & En local
    @Column(name="modalidad")
    private Integer modalidad;

    @Column(name="video_presentacion")
    private String videoPresentacion;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "servicio")
    private List<Horario> horarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getAnunciante() {
        return anunciante;
    }

    public void setAnunciante(Usuario anunciante) {
        this.anunciante = anunciante;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public BigDecimal getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(BigDecimal costoServicio) {
        this.costoServicio = costoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstaHabilitado() {
        return estaHabilitado;
    }

    public void setEstaHabilitado(Boolean estaHabilitado) {
        this.estaHabilitado = estaHabilitado;
    }

    public Double getValoracion() {
        return valoracion;
    }

    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getModalidad() {
        return modalidad;
    }

    public void setModalidad(Integer modalidad) {
        this.modalidad = modalidad;
    }

    public String getVideoPresentacion() {
        return videoPresentacion;
    }

    public void setVideoPresentacion(String videoPresentacion) {
        this.videoPresentacion = videoPresentacion;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}


