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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sobrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sobrante.findAll", query = "SELECT s FROM Sobrante s")
    , @NamedQuery(name = "Sobrante.findByIdSobrante", query = "SELECT s FROM Sobrante s WHERE s.idSobrante = :idSobrante")
    , @NamedQuery(name = "Sobrante.findByEstado", query = "SELECT s FROM Sobrante s WHERE s.estado = :estado")
    , @NamedQuery(name = "Sobrante.findByCantidad", query = "SELECT s FROM Sobrante s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "Sobrante.findByFechaCreacion", query = "SELECT s FROM Sobrante s WHERE s.fechaCreacion = :fechaCreacion")})
public class Sobrante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSobrante")
    private Integer idSobrante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSobrante", fetch = FetchType.LAZY)
    private List<Sobrantedetalle> sobrantedetalleList;
    @JoinColumn(name = "codProduccion", referencedColumnName = "idProduccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produccion codProduccion;
    @JoinColumn(name = "codStockMaterial", referencedColumnName = "idStockMaterial")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stockmaterial codStockMaterial;

    public Sobrante() {
    }

    public Sobrante(Integer idSobrante) {
        this.idSobrante = idSobrante;
    }

    public Sobrante(Integer idSobrante, String estado, Date fechaCreacion) {
        this.idSobrante = idSobrante;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdSobrante() {
        return idSobrante;
    }

    public void setIdSobrante(Integer idSobrante) {
        this.idSobrante = idSobrante;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Sobrantedetalle> getSobrantedetalleList() {
        return sobrantedetalleList;
    }

    public void setSobrantedetalleList(List<Sobrantedetalle> sobrantedetalleList) {
        this.sobrantedetalleList = sobrantedetalleList;
    }

    public Produccion getCodProduccion() {
        return codProduccion;
    }

    public void setCodProduccion(Produccion codProduccion) {
        this.codProduccion = codProduccion;
    }

    public Stockmaterial getCodStockMaterial() {
        return codStockMaterial;
    }

    public void setCodStockMaterial(Stockmaterial codStockMaterial) {
        this.codStockMaterial = codStockMaterial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSobrante != null ? idSobrante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sobrante)) {
            return false;
        }
        Sobrante other = (Sobrante) object;
        if ((this.idSobrante == null && other.idSobrante != null) || (this.idSobrante != null && !this.idSobrante.equals(other.idSobrante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Sobrante[ idSobrante=" + idSobrante + " ]";
    }
    
}
