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
@Table(name = "produccionnovedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccionnovedad.findAll", query = "SELECT p FROM Produccionnovedad p")
    , @NamedQuery(name = "Produccionnovedad.findByIdProduccionNovedad", query = "SELECT p FROM Produccionnovedad p WHERE p.idProduccionNovedad = :idProduccionNovedad")})
public class Produccionnovedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduccionNovedad")
    private Integer idProduccionNovedad;
    @JoinColumn(name = "codNovedad", referencedColumnName = "idNovedad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novedad codNovedad;
    @JoinColumn(name = "codProduccion", referencedColumnName = "idProduccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produccion codProduccion;

    public Produccionnovedad() {
    }

    public Produccionnovedad(Integer idProduccionNovedad) {
        this.idProduccionNovedad = idProduccionNovedad;
    }

    public Integer getIdProduccionNovedad() {
        return idProduccionNovedad;
    }

    public void setIdProduccionNovedad(Integer idProduccionNovedad) {
        this.idProduccionNovedad = idProduccionNovedad;
    }

    public Novedad getCodNovedad() {
        return codNovedad;
    }

    public void setCodNovedad(Novedad codNovedad) {
        this.codNovedad = codNovedad;
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
        hash += (idProduccionNovedad != null ? idProduccionNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccionnovedad)) {
            return false;
        }
        Produccionnovedad other = (Produccionnovedad) object;
        if ((this.idProduccionNovedad == null && other.idProduccionNovedad != null) || (this.idProduccionNovedad != null && !this.idProduccionNovedad.equals(other.idProduccionNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Produccionnovedad[ idProduccionNovedad=" + idProduccionNovedad + " ]";
    }
    
}
