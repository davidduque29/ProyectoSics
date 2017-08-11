/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "plandeaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plandeaccion.findAll", query = "SELECT p FROM Plandeaccion p")
    , @NamedQuery(name = "Plandeaccion.findByIdPlanDeAccion", query = "SELECT p FROM Plandeaccion p WHERE p.idPlanDeAccion = :idPlanDeAccion")
    , @NamedQuery(name = "Plandeaccion.findByPlan", query = "SELECT p FROM Plandeaccion p WHERE p.plan = :plan")
    , @NamedQuery(name = "Plandeaccion.findByObservacion", query = "SELECT p FROM Plandeaccion p WHERE p.observacion = :observacion")
    , @NamedQuery(name = "Plandeaccion.findByFechaCreacion", query = "SELECT p FROM Plandeaccion p WHERE p.fechaCreacion = :fechaCreacion")})
public class Plandeaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlanDeAccion")
    private Integer idPlanDeAccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "plan")
    private String plan;
    @Size(max = 45)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "codNovedad", referencedColumnName = "idNovedad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novedad codNovedad;
    @JoinColumn(name = "estado", referencedColumnName = "idEstadoPlanAccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estadoplanaccion estado;
    @JoinColumn(name = "usuarioRegistro", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioRegistro;

    public Plandeaccion() {
    }

    public Plandeaccion(Integer idPlanDeAccion) {
        this.idPlanDeAccion = idPlanDeAccion;
    }

    public Plandeaccion(Integer idPlanDeAccion, String plan, Date fechaCreacion) {
        this.idPlanDeAccion = idPlanDeAccion;
        this.plan = plan;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdPlanDeAccion() {
        return idPlanDeAccion;
    }

    public void setIdPlanDeAccion(Integer idPlanDeAccion) {
        this.idPlanDeAccion = idPlanDeAccion;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Novedad getCodNovedad() {
        return codNovedad;
    }

    public void setCodNovedad(Novedad codNovedad) {
        this.codNovedad = codNovedad;
    }

    public Estadoplanaccion getEstado() {
        return estado;
    }

    public void setEstado(Estadoplanaccion estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanDeAccion != null ? idPlanDeAccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plandeaccion)) {
            return false;
        }
        Plandeaccion other = (Plandeaccion) object;
        if ((this.idPlanDeAccion == null && other.idPlanDeAccion != null) || (this.idPlanDeAccion != null && !this.idPlanDeAccion.equals(other.idPlanDeAccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Plandeaccion[ idPlanDeAccion=" + idPlanDeAccion + " ]";
    }
    
}
