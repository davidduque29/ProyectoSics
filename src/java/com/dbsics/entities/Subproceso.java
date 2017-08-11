/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "subproceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subproceso.findAll", query = "SELECT s FROM Subproceso s")
    , @NamedQuery(name = "Subproceso.findByIdSubProceso", query = "SELECT s FROM Subproceso s WHERE s.idSubProceso = :idSubProceso")
    , @NamedQuery(name = "Subproceso.findBySubProceso", query = "SELECT s FROM Subproceso s WHERE s.subProceso = :subProceso")
    , @NamedQuery(name = "Subproceso.findByEstado", query = "SELECT s FROM Subproceso s WHERE s.estado = :estado")
    , @NamedQuery(name = "Subproceso.findByFormula", query = "SELECT s FROM Subproceso s WHERE s.formula = :formula")
    , @NamedQuery(name = "Subproceso.findByFechaCreacion", query = "SELECT s FROM Subproceso s WHERE s.fechaCreacion = :fechaCreacion")})
public class Subproceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSubProceso")
    private Integer idSubProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "subProceso")
    private String subProceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "formula")
    private String formula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSubProceso", fetch = FetchType.LAZY)
    private List<Produccionmaterial> produccionmaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSubProceso", fetch = FetchType.LAZY)
    private List<Formula> formulaList;

    public Subproceso() {
    }

    public Subproceso(Integer idSubProceso) {
        this.idSubProceso = idSubProceso;
    }

    public Subproceso(Integer idSubProceso, String subProceso, String estado, String formula, Date fechaCreacion) {
        this.idSubProceso = idSubProceso;
        this.subProceso = subProceso;
        this.estado = estado;
        this.formula = formula;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdSubProceso() {
        return idSubProceso;
    }

    public void setIdSubProceso(Integer idSubProceso) {
        this.idSubProceso = idSubProceso;
    }

    public String getSubProceso() {
        return subProceso;
    }

    public void setSubProceso(String subProceso) {
        this.subProceso = subProceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Produccionmaterial> getProduccionmaterialList() {
        return produccionmaterialList;
    }

    public void setProduccionmaterialList(List<Produccionmaterial> produccionmaterialList) {
        this.produccionmaterialList = produccionmaterialList;
    }

    @XmlTransient
    public List<Formula> getFormulaList() {
        return formulaList;
    }

    public void setFormulaList(List<Formula> formulaList) {
        this.formulaList = formulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubProceso != null ? idSubProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subproceso)) {
            return false;
        }
        Subproceso other = (Subproceso) object;
        if ((this.idSubProceso == null && other.idSubProceso != null) || (this.idSubProceso != null && !this.idSubProceso.equals(other.idSubProceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Subproceso[ idSubProceso=" + idSubProceso + " ]";
    }
    
}
