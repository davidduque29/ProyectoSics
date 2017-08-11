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
@Table(name = "formula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formula.findAll", query = "SELECT f FROM Formula f")
    , @NamedQuery(name = "Formula.findByIdformula", query = "SELECT f FROM Formula f WHERE f.idformula = :idformula")
    , @NamedQuery(name = "Formula.findByFormula", query = "SELECT f FROM Formula f WHERE f.formula = :formula")
    , @NamedQuery(name = "Formula.findByCantidad", query = "SELECT f FROM Formula f WHERE f.cantidad = :cantidad")})
public class Formula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idformula")
    private Integer idformula;
    @Size(max = 45)
    @Column(name = "formula")
    private String formula;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "codStockMaterial", referencedColumnName = "idStockMaterial")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stockmaterial codStockMaterial;
    @JoinColumn(name = "codSubProceso", referencedColumnName = "idSubProceso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subproceso codSubProceso;
    @JoinColumn(name = "usuarioRegistro", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioRegistro;

    public Formula() {
    }

    public Formula(Integer idformula) {
        this.idformula = idformula;
    }

    public Integer getIdformula() {
        return idformula;
    }

    public void setIdformula(Integer idformula) {
        this.idformula = idformula;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Stockmaterial getCodStockMaterial() {
        return codStockMaterial;
    }

    public void setCodStockMaterial(Stockmaterial codStockMaterial) {
        this.codStockMaterial = codStockMaterial;
    }

    public Subproceso getCodSubProceso() {
        return codSubProceso;
    }

    public void setCodSubProceso(Subproceso codSubProceso) {
        this.codSubProceso = codSubProceso;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformula != null ? idformula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formula)) {
            return false;
        }
        Formula other = (Formula) object;
        if ((this.idformula == null && other.idformula != null) || (this.idformula != null && !this.idformula.equals(other.idformula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Formula[ idformula=" + idformula + " ]";
    }
    
}
