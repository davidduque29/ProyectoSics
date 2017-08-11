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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "preproceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preproceso.findAll", query = "SELECT p FROM Preproceso p")
    , @NamedQuery(name = "Preproceso.findByIdPreProceso", query = "SELECT p FROM Preproceso p WHERE p.idPreProceso = :idPreProceso")
    , @NamedQuery(name = "Preproceso.findByPreProceso", query = "SELECT p FROM Preproceso p WHERE p.preProceso = :preProceso")})
public class Preproceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPreProceso")
    private Integer idPreProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "preProceso")
    private String preProceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPreProceso", fetch = FetchType.LAZY)
    private List<Preproduccion> preproduccionList;

    public Preproceso() {
    }

    public Preproceso(Integer idPreProceso) {
        this.idPreProceso = idPreProceso;
    }

    public Preproceso(Integer idPreProceso, String preProceso) {
        this.idPreProceso = idPreProceso;
        this.preProceso = preProceso;
    }

    public Integer getIdPreProceso() {
        return idPreProceso;
    }

    public void setIdPreProceso(Integer idPreProceso) {
        this.idPreProceso = idPreProceso;
    }

    public String getPreProceso() {
        return preProceso;
    }

    public void setPreProceso(String preProceso) {
        this.preProceso = preProceso;
    }

    @XmlTransient
    public List<Preproduccion> getPreproduccionList() {
        return preproduccionList;
    }

    public void setPreproduccionList(List<Preproduccion> preproduccionList) {
        this.preproduccionList = preproduccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreProceso != null ? idPreProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preproceso)) {
            return false;
        }
        Preproceso other = (Preproceso) object;
        if ((this.idPreProceso == null && other.idPreProceso != null) || (this.idPreProceso != null && !this.idPreProceso.equals(other.idPreProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Preproceso[ idPreProceso=" + idPreProceso + " ]";
    }
    
}
