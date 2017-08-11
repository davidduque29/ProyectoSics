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
@Table(name = "maquinanovedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquinanovedad.findAll", query = "SELECT m FROM Maquinanovedad m")
    , @NamedQuery(name = "Maquinanovedad.findByIdMaquinaNovedad", query = "SELECT m FROM Maquinanovedad m WHERE m.idMaquinaNovedad = :idMaquinaNovedad")})
public class Maquinanovedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaquinaNovedad")
    private Integer idMaquinaNovedad;
    @JoinColumn(name = "codMaquina", referencedColumnName = "idMaquina")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Maquina codMaquina;
    @JoinColumn(name = "codNovedad", referencedColumnName = "idNovedad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Novedad codNovedad;

    public Maquinanovedad() {
    }

    public Maquinanovedad(Integer idMaquinaNovedad) {
        this.idMaquinaNovedad = idMaquinaNovedad;
    }

    public Integer getIdMaquinaNovedad() {
        return idMaquinaNovedad;
    }

    public void setIdMaquinaNovedad(Integer idMaquinaNovedad) {
        this.idMaquinaNovedad = idMaquinaNovedad;
    }

    public Maquina getCodMaquina() {
        return codMaquina;
    }

    public void setCodMaquina(Maquina codMaquina) {
        this.codMaquina = codMaquina;
    }

    public Novedad getCodNovedad() {
        return codNovedad;
    }

    public void setCodNovedad(Novedad codNovedad) {
        this.codNovedad = codNovedad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquinaNovedad != null ? idMaquinaNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquinanovedad)) {
            return false;
        }
        Maquinanovedad other = (Maquinanovedad) object;
        if ((this.idMaquinaNovedad == null && other.idMaquinaNovedad != null) || (this.idMaquinaNovedad != null && !this.idMaquinaNovedad.equals(other.idMaquinaNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Maquinanovedad[ idMaquinaNovedad=" + idMaquinaNovedad + " ]";
    }
    
}
