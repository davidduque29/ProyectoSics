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
@Table(name = "productofinal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productofinal.findAll", query = "SELECT p FROM Productofinal p")
    , @NamedQuery(name = "Productofinal.findByIdProductoFinal", query = "SELECT p FROM Productofinal p WHERE p.idProductoFinal = :idProductoFinal")
    , @NamedQuery(name = "Productofinal.findByFechaCreacion", query = "SELECT p FROM Productofinal p WHERE p.fechaCreacion = :fechaCreacion")})
public class Productofinal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductoFinal")
    private Integer idProductoFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "codProduccion", referencedColumnName = "idProduccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produccion codProduccion;

    public Productofinal() {
    }

    public Productofinal(Integer idProductoFinal) {
        this.idProductoFinal = idProductoFinal;
    }

    public Productofinal(Integer idProductoFinal, Date fechaCreacion) {
        this.idProductoFinal = idProductoFinal;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdProductoFinal() {
        return idProductoFinal;
    }

    public void setIdProductoFinal(Integer idProductoFinal) {
        this.idProductoFinal = idProductoFinal;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Produccion getCodProduccion() {
        return codProduccion;
    }

    public void setCodProduccion(Produccion codProduccion) {
        this.codProduccion = codProduccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductoFinal != null ? idProductoFinal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productofinal)) {
            return false;
        }
        Productofinal other = (Productofinal) object;
        if ((this.idProductoFinal == null && other.idProductoFinal != null) || (this.idProductoFinal != null && !this.idProductoFinal.equals(other.idProductoFinal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Productofinal[ idProductoFinal=" + idProductoFinal + " ]";
    }
    
}
