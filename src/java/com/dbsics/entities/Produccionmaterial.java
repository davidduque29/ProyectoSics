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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "produccionmaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccionmaterial.findAll", query = "SELECT p FROM Produccionmaterial p")
    , @NamedQuery(name = "Produccionmaterial.findByIdProdMaterial", query = "SELECT p FROM Produccionmaterial p WHERE p.idProdMaterial = :idProdMaterial")
    , @NamedQuery(name = "Produccionmaterial.findByCantidad", query = "SELECT p FROM Produccionmaterial p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Produccionmaterial.findByEstado", query = "SELECT p FROM Produccionmaterial p WHERE p.estado = :estado")
    , @NamedQuery(name = "Produccionmaterial.findByFechaCreacion", query = "SELECT p FROM Produccionmaterial p WHERE p.fechaCreacion = :fechaCreacion")})
public class Produccionmaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProdMaterial")
    private Integer idProdMaterial;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "codPreProduccion", referencedColumnName = "idPreProduccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Preproduccion codPreProduccion;
    @JoinColumn(name = "codStockMaterial", referencedColumnName = "idStockMaterial")
    @ManyToOne(fetch = FetchType.LAZY)
    private Stockmaterial codStockMaterial;
    @JoinColumn(name = "codSubProceso", referencedColumnName = "idSubProceso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subproceso codSubProceso;
    @JoinColumn(name = "usuarioRegistro", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioRegistro;

    public Produccionmaterial() {
    }

    public Produccionmaterial(Integer idProdMaterial) {
        this.idProdMaterial = idProdMaterial;
    }

    public Integer getIdProdMaterial() {
        return idProdMaterial;
    }

    public void setIdProdMaterial(Integer idProdMaterial) {
        this.idProdMaterial = idProdMaterial;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Preproduccion getCodPreProduccion() {
        return codPreProduccion;
    }

    public void setCodPreProduccion(Preproduccion codPreProduccion) {
        this.codPreProduccion = codPreProduccion;
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
        hash += (idProdMaterial != null ? idProdMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccionmaterial)) {
            return false;
        }
        Produccionmaterial other = (Produccionmaterial) object;
        if ((this.idProdMaterial == null && other.idProdMaterial != null) || (this.idProdMaterial != null && !this.idProdMaterial.equals(other.idProdMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Produccionmaterial[ idProdMaterial=" + idProdMaterial + " ]";
    }
    
}
