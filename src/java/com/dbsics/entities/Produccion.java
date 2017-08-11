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
@Table(name = "produccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produccion.findAll", query = "SELECT p FROM Produccion p")
    , @NamedQuery(name = "Produccion.findByIdProduccion", query = "SELECT p FROM Produccion p WHERE p.idProduccion = :idProduccion")
    , @NamedQuery(name = "Produccion.findByProceso", query = "SELECT p FROM Produccion p WHERE p.proceso = :proceso")
    , @NamedQuery(name = "Produccion.findByEstado", query = "SELECT p FROM Produccion p WHERE p.estado = :estado")
    , @NamedQuery(name = "Produccion.findBySobrante", query = "SELECT p FROM Produccion p WHERE p.sobrante = :sobrante")
    , @NamedQuery(name = "Produccion.findByFechaCreacion", query = "SELECT p FROM Produccion p WHERE p.fechaCreacion = :fechaCreacion")})
public class Produccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProduccion")
    private Integer idProduccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "proceso")
    private String proceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "estado")
    private String estado;
    @Size(max = 2)
    @Column(name = "sobrante")
    private String sobrante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProduccion", fetch = FetchType.LAZY)
    private List<Produccionnovedad> produccionnovedadList;
    @JoinColumn(name = "aprobador", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario aprobador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProduccion", fetch = FetchType.LAZY)
    private List<Sobrante> sobranteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProduccion", fetch = FetchType.LAZY)
    private List<Preproduccionprod> preproduccionprodList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProduccion", fetch = FetchType.LAZY)
    private List<Productofinal> productofinalList;

    public Produccion() {
    }

    public Produccion(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public Produccion(Integer idProduccion, String proceso, String estado, Date fechaCreacion) {
        this.idProduccion = idProduccion;
        this.proceso = proceso;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(Integer idProduccion) {
        this.idProduccion = idProduccion;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSobrante() {
        return sobrante;
    }

    public void setSobrante(String sobrante) {
        this.sobrante = sobrante;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<Produccionnovedad> getProduccionnovedadList() {
        return produccionnovedadList;
    }

    public void setProduccionnovedadList(List<Produccionnovedad> produccionnovedadList) {
        this.produccionnovedadList = produccionnovedadList;
    }

    public Usuario getAprobador() {
        return aprobador;
    }

    public void setAprobador(Usuario aprobador) {
        this.aprobador = aprobador;
    }

    @XmlTransient
    public List<Sobrante> getSobranteList() {
        return sobranteList;
    }

    public void setSobranteList(List<Sobrante> sobranteList) {
        this.sobranteList = sobranteList;
    }

    @XmlTransient
    public List<Preproduccionprod> getPreproduccionprodList() {
        return preproduccionprodList;
    }

    public void setPreproduccionprodList(List<Preproduccionprod> preproduccionprodList) {
        this.preproduccionprodList = preproduccionprodList;
    }

    @XmlTransient
    public List<Productofinal> getProductofinalList() {
        return productofinalList;
    }

    public void setProductofinalList(List<Productofinal> productofinalList) {
        this.productofinalList = productofinalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduccion != null ? idProduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produccion)) {
            return false;
        }
        Produccion other = (Produccion) object;
        if ((this.idProduccion == null && other.idProduccion != null) || (this.idProduccion != null && !this.idProduccion.equals(other.idProduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Produccion[ idProduccion=" + idProduccion + " ]";
    }
    
}
