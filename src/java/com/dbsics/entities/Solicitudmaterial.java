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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "solicitudmaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudmaterial.findAll", query = "SELECT s FROM Solicitudmaterial s")
    , @NamedQuery(name = "Solicitudmaterial.findByIdSolicitudMaterial", query = "SELECT s FROM Solicitudmaterial s WHERE s.idSolicitudMaterial = :idSolicitudMaterial")
    , @NamedQuery(name = "Solicitudmaterial.findByFechaCreacion", query = "SELECT s FROM Solicitudmaterial s WHERE s.fechaCreacion = :fechaCreacion")})
public class Solicitudmaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudMaterial")
    private Integer idSolicitudMaterial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "codPreProduccion", referencedColumnName = "idPreProduccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Preproduccion codPreProduccion;
    @JoinColumn(name = "codUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario codUsuario;

    public Solicitudmaterial() {
    }

    public Solicitudmaterial(Integer idSolicitudMaterial) {
        this.idSolicitudMaterial = idSolicitudMaterial;
    }

    public Solicitudmaterial(Integer idSolicitudMaterial, Date fechaCreacion) {
        this.idSolicitudMaterial = idSolicitudMaterial;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdSolicitudMaterial() {
        return idSolicitudMaterial;
    }

    public void setIdSolicitudMaterial(Integer idSolicitudMaterial) {
        this.idSolicitudMaterial = idSolicitudMaterial;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Preproduccion getCodPreProduccion() {
        return codPreProduccion;
    }

    public void setCodPreProduccion(Preproduccion codPreProduccion) {
        this.codPreProduccion = codPreProduccion;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudMaterial != null ? idSolicitudMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudmaterial)) {
            return false;
        }
        Solicitudmaterial other = (Solicitudmaterial) object;
        if ((this.idSolicitudMaterial == null && other.idSolicitudMaterial != null) || (this.idSolicitudMaterial != null && !this.idSolicitudMaterial.equals(other.idSolicitudMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Solicitudmaterial[ idSolicitudMaterial=" + idSolicitudMaterial + " ]";
    }
    
}
