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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "preproduccionprod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preproduccionprod.findAll", query = "SELECT p FROM Preproduccionprod p")
    , @NamedQuery(name = "Preproduccionprod.findByIdPreProduccionProd", query = "SELECT p FROM Preproduccionprod p WHERE p.idPreProduccionProd = :idPreProduccionProd")})
public class Preproduccionprod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPreProduccionProd")
    private Integer idPreProduccionProd;
    @JoinColumn(name = "codProduccion", referencedColumnName = "idProduccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produccion codProduccion;
    @JoinColumn(name = "codpreProduccion", referencedColumnName = "idPreProduccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Preproduccion codpreProduccion;
    @JoinColumn(name = "codUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario codUsuario;

    public Preproduccionprod() {
    }

    public Preproduccionprod(Integer idPreProduccionProd) {
        this.idPreProduccionProd = idPreProduccionProd;
    }

    public Integer getIdPreProduccionProd() {
        return idPreProduccionProd;
    }

    public void setIdPreProduccionProd(Integer idPreProduccionProd) {
        this.idPreProduccionProd = idPreProduccionProd;
    }

    public Produccion getCodProduccion() {
        return codProduccion;
    }

    public void setCodProduccion(Produccion codProduccion) {
        this.codProduccion = codProduccion;
    }

    public Preproduccion getCodpreProduccion() {
        return codpreProduccion;
    }

    public void setCodpreProduccion(Preproduccion codpreProduccion) {
        this.codpreProduccion = codpreProduccion;
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
        hash += (idPreProduccionProd != null ? idPreProduccionProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preproduccionprod)) {
            return false;
        }
        Preproduccionprod other = (Preproduccionprod) object;
        if ((this.idPreProduccionProd == null && other.idPreProduccionProd != null) || (this.idPreProduccionProd != null && !this.idPreProduccionProd.equals(other.idPreProduccionProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Preproduccionprod[ idPreProduccionProd=" + idPreProduccionProd + " ]";
    }
    
}
