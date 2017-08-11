/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "observaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observaciones.findAll", query = "SELECT o FROM Observaciones o")
    , @NamedQuery(name = "Observaciones.findByIdObservaciones", query = "SELECT o FROM Observaciones o WHERE o.idObservaciones = :idObservaciones")
    , @NamedQuery(name = "Observaciones.findByDescripcion", query = "SELECT o FROM Observaciones o WHERE o.descripcion = :descripcion")})
public class Observaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idObservaciones")
    private Integer idObservaciones;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "codUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario codUsuario;

    public Observaciones() {
    }

    public Observaciones(Integer idObservaciones) {
        this.idObservaciones = idObservaciones;
    }

    public Integer getIdObservaciones() {
        return idObservaciones;
    }

    public void setIdObservaciones(Integer idObservaciones) {
        this.idObservaciones = idObservaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idObservaciones != null ? idObservaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observaciones)) {
            return false;
        }
        Observaciones other = (Observaciones) object;
        if ((this.idObservaciones == null && other.idObservaciones != null) || (this.idObservaciones != null && !this.idObservaciones.equals(other.idObservaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Observaciones[ idObservaciones=" + idObservaciones + " ]";
    }
    
}
