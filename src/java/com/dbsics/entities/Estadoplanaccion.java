/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "estadoplanaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoplanaccion.findAll", query = "SELECT e FROM Estadoplanaccion e")
    , @NamedQuery(name = "Estadoplanaccion.findByIdEstadoPlanAccion", query = "SELECT e FROM Estadoplanaccion e WHERE e.idEstadoPlanAccion = :idEstadoPlanAccion")
    , @NamedQuery(name = "Estadoplanaccion.findByEstado", query = "SELECT e FROM Estadoplanaccion e WHERE e.estado = :estado")})
public class Estadoplanaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstadoPlanAccion")
    private Integer idEstadoPlanAccion;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Plandeaccion> plandeaccionList;

    public Estadoplanaccion() {
    }

    public Estadoplanaccion(Integer idEstadoPlanAccion) {
        this.idEstadoPlanAccion = idEstadoPlanAccion;
    }

    public Integer getIdEstadoPlanAccion() {
        return idEstadoPlanAccion;
    }

    public void setIdEstadoPlanAccion(Integer idEstadoPlanAccion) {
        this.idEstadoPlanAccion = idEstadoPlanAccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Plandeaccion> getPlandeaccionList() {
        return plandeaccionList;
    }

    public void setPlandeaccionList(List<Plandeaccion> plandeaccionList) {
        this.plandeaccionList = plandeaccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPlanAccion != null ? idEstadoPlanAccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoplanaccion)) {
            return false;
        }
        Estadoplanaccion other = (Estadoplanaccion) object;
        if ((this.idEstadoPlanAccion == null && other.idEstadoPlanAccion != null) || (this.idEstadoPlanAccion != null && !this.idEstadoPlanAccion.equals(other.idEstadoPlanAccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Estadoplanaccion[ idEstadoPlanAccion=" + idEstadoPlanAccion + " ]";
    }
    
}
