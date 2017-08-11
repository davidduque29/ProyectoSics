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
@Table(name = "sobrantedetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sobrantedetalle.findAll", query = "SELECT s FROM Sobrantedetalle s")
    , @NamedQuery(name = "Sobrantedetalle.findByIdSobranteDetalle", query = "SELECT s FROM Sobrantedetalle s WHERE s.idSobranteDetalle = :idSobranteDetalle")
    , @NamedQuery(name = "Sobrantedetalle.findByCodProduccion", query = "SELECT s FROM Sobrantedetalle s WHERE s.codProduccion = :codProduccion")
    , @NamedQuery(name = "Sobrantedetalle.findByCodStockMaterial", query = "SELECT s FROM Sobrantedetalle s WHERE s.codStockMaterial = :codStockMaterial")
    , @NamedQuery(name = "Sobrantedetalle.findByEstado", query = "SELECT s FROM Sobrantedetalle s WHERE s.estado = :estado")
    , @NamedQuery(name = "Sobrantedetalle.findByCantidad", query = "SELECT s FROM Sobrantedetalle s WHERE s.cantidad = :cantidad")})
public class Sobrantedetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSobranteDetalle")
    private Integer idSobranteDetalle;
    @Column(name = "codProduccion")
    private Integer codProduccion;
    @Column(name = "codStockMaterial")
    private Integer codStockMaterial;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "codSobrante", referencedColumnName = "idSobrante")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sobrante codSobrante;

    public Sobrantedetalle() {
    }

    public Sobrantedetalle(Integer idSobranteDetalle) {
        this.idSobranteDetalle = idSobranteDetalle;
    }

    public Integer getIdSobranteDetalle() {
        return idSobranteDetalle;
    }

    public void setIdSobranteDetalle(Integer idSobranteDetalle) {
        this.idSobranteDetalle = idSobranteDetalle;
    }

    public Integer getCodProduccion() {
        return codProduccion;
    }

    public void setCodProduccion(Integer codProduccion) {
        this.codProduccion = codProduccion;
    }

    public Integer getCodStockMaterial() {
        return codStockMaterial;
    }

    public void setCodStockMaterial(Integer codStockMaterial) {
        this.codStockMaterial = codStockMaterial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Sobrante getCodSobrante() {
        return codSobrante;
    }

    public void setCodSobrante(Sobrante codSobrante) {
        this.codSobrante = codSobrante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSobranteDetalle != null ? idSobranteDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sobrantedetalle)) {
            return false;
        }
        Sobrantedetalle other = (Sobrantedetalle) object;
        if ((this.idSobranteDetalle == null && other.idSobranteDetalle != null) || (this.idSobranteDetalle != null && !this.idSobranteDetalle.equals(other.idSobranteDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Sobrantedetalle[ idSobranteDetalle=" + idSobranteDetalle + " ]";
    }
    
}
