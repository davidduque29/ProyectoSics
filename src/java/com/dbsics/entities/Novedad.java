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
@Table(name = "novedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedad.findAll", query = "SELECT n FROM Novedad n")
    , @NamedQuery(name = "Novedad.findByIdNovedad", query = "SELECT n FROM Novedad n WHERE n.idNovedad = :idNovedad")
    , @NamedQuery(name = "Novedad.findByNovedad", query = "SELECT n FROM Novedad n WHERE n.novedad = :novedad")
    , @NamedQuery(name = "Novedad.findByTipo", query = "SELECT n FROM Novedad n WHERE n.tipo = :tipo")
    , @NamedQuery(name = "Novedad.findByFechaNovedad", query = "SELECT n FROM Novedad n WHERE n.fechaNovedad = :fechaNovedad")})
public class Novedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNovedad")
    private Integer idNovedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "novedad")
    private String novedad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNovedad")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNovedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNovedad", fetch = FetchType.LAZY)
    private List<Produccionnovedad> produccionnovedadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNovedad", fetch = FetchType.LAZY)
    private List<Maquinanovedad> maquinanovedadList;
    @JoinColumn(name = "codUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario codUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codNovedad", fetch = FetchType.LAZY)
    private List<Plandeaccion> plandeaccionList;

    public Novedad() {
    }

    public Novedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public Novedad(Integer idNovedad, String novedad, String tipo, Date fechaNovedad) {
        this.idNovedad = idNovedad;
        this.novedad = novedad;
        this.tipo = tipo;
        this.fechaNovedad = fechaNovedad;
    }

    public Integer getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(Integer idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaNovedad() {
        return fechaNovedad;
    }

    public void setFechaNovedad(Date fechaNovedad) {
        this.fechaNovedad = fechaNovedad;
    }

    @XmlTransient
    public List<Produccionnovedad> getProduccionnovedadList() {
        return produccionnovedadList;
    }

    public void setProduccionnovedadList(List<Produccionnovedad> produccionnovedadList) {
        this.produccionnovedadList = produccionnovedadList;
    }

    @XmlTransient
    public List<Maquinanovedad> getMaquinanovedadList() {
        return maquinanovedadList;
    }

    public void setMaquinanovedadList(List<Maquinanovedad> maquinanovedadList) {
        this.maquinanovedadList = maquinanovedadList;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
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
        hash += (idNovedad != null ? idNovedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedad)) {
            return false;
        }
        Novedad other = (Novedad) object;
        if ((this.idNovedad == null && other.idNovedad != null) || (this.idNovedad != null && !this.idNovedad.equals(other.idNovedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Novedad[ idNovedad=" + idNovedad + " ]";
    }
    
}
