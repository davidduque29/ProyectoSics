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
@Table(name = "preproduccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preproduccion.findAll", query = "SELECT p FROM Preproduccion p")
    , @NamedQuery(name = "Preproduccion.findByIdPreProduccion", query = "SELECT p FROM Preproduccion p WHERE p.idPreProduccion = :idPreProduccion")
    , @NamedQuery(name = "Preproduccion.findByCantidad", query = "SELECT p FROM Preproduccion p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Preproduccion.findByPedido", query = "SELECT p FROM Preproduccion p WHERE p.pedido = :pedido")
    , @NamedQuery(name = "Preproduccion.findByEstado", query = "SELECT p FROM Preproduccion p WHERE p.estado = :estado")
    , @NamedQuery(name = "Preproduccion.findByFechaCreacion", query = "SELECT p FROM Preproduccion p WHERE p.fechaCreacion = :fechaCreacion")})
public class Preproduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPreProduccion")
    private Integer idPreProduccion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 80)
    @Column(name = "pedido")
    private String pedido;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "codPreProceso", referencedColumnName = "idPreProceso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Preproceso codPreProceso;
    @JoinColumn(name = "usuarioExplosion", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioExplosion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPreProduccion", fetch = FetchType.LAZY)
    private List<Solicitudmaterial> solicitudmaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPreProduccion", fetch = FetchType.LAZY)
    private List<Produccionmaterial> produccionmaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpreProduccion", fetch = FetchType.LAZY)
    private List<Preproduccionprod> preproduccionprodList;

    public Preproduccion() {
    }

    public Preproduccion(Integer idPreProduccion) {
        this.idPreProduccion = idPreProduccion;
    }

    public Preproduccion(Integer idPreProduccion, Date fechaCreacion) {
        this.idPreProduccion = idPreProduccion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdPreProduccion() {
        return idPreProduccion;
    }

    public void setIdPreProduccion(Integer idPreProduccion) {
        this.idPreProduccion = idPreProduccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
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

    public Preproceso getCodPreProceso() {
        return codPreProceso;
    }

    public void setCodPreProceso(Preproceso codPreProceso) {
        this.codPreProceso = codPreProceso;
    }

    public Usuario getUsuarioExplosion() {
        return usuarioExplosion;
    }

    public void setUsuarioExplosion(Usuario usuarioExplosion) {
        this.usuarioExplosion = usuarioExplosion;
    }

    @XmlTransient
    public List<Solicitudmaterial> getSolicitudmaterialList() {
        return solicitudmaterialList;
    }

    public void setSolicitudmaterialList(List<Solicitudmaterial> solicitudmaterialList) {
        this.solicitudmaterialList = solicitudmaterialList;
    }

    @XmlTransient
    public List<Produccionmaterial> getProduccionmaterialList() {
        return produccionmaterialList;
    }

    public void setProduccionmaterialList(List<Produccionmaterial> produccionmaterialList) {
        this.produccionmaterialList = produccionmaterialList;
    }

    @XmlTransient
    public List<Preproduccionprod> getPreproduccionprodList() {
        return preproduccionprodList;
    }

    public void setPreproduccionprodList(List<Preproduccionprod> preproduccionprodList) {
        this.preproduccionprodList = preproduccionprodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPreProduccion != null ? idPreProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preproduccion)) {
            return false;
        }
        Preproduccion other = (Preproduccion) object;
        if ((this.idPreProduccion == null && other.idPreProduccion != null) || (this.idPreProduccion != null && !this.idPreProduccion.equals(other.idPreProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Preproduccion[ idPreProduccion=" + idPreProduccion + " ]";
    }
    
}
