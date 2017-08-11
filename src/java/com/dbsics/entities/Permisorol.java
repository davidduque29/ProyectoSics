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
@Table(name = "permisorol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisorol.findAll", query = "SELECT p FROM Permisorol p")
    , @NamedQuery(name = "Permisorol.findByIdPermisoRol", query = "SELECT p FROM Permisorol p WHERE p.idPermisoRol = :idPermisoRol")})
public class Permisorol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermisoRol")
    private Integer idPermisoRol;
    @JoinColumn(name = "codRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol codRol;
    @JoinColumn(name = "codPermiso", referencedColumnName = "idPermiso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Permiso codPermiso;

    public Permisorol() {
    }

    public Permisorol(Integer idPermisoRol) {
        this.idPermisoRol = idPermisoRol;
    }

    public Integer getIdPermisoRol() {
        return idPermisoRol;
    }

    public void setIdPermisoRol(Integer idPermisoRol) {
        this.idPermisoRol = idPermisoRol;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    public Permiso getCodPermiso() {
        return codPermiso;
    }

    public void setCodPermiso(Permiso codPermiso) {
        this.codPermiso = codPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisoRol != null ? idPermisoRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisorol)) {
            return false;
        }
        Permisorol other = (Permisorol) object;
        if ((this.idPermisoRol == null && other.idPermisoRol != null) || (this.idPermisoRol != null && !this.idPermisoRol.equals(other.idPermisoRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Permisorol[ idPermisoRol=" + idPermisoRol + " ]";
    }
    
}
