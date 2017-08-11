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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "maquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m")
    , @NamedQuery(name = "Maquina.findByIdMaquina", query = "SELECT m FROM Maquina m WHERE m.idMaquina = :idMaquina")
    , @NamedQuery(name = "Maquina.findBySerial", query = "SELECT m FROM Maquina m WHERE m.serial = :serial")
    , @NamedQuery(name = "Maquina.findByMaquina", query = "SELECT m FROM Maquina m WHERE m.maquina = :maquina")
    , @NamedQuery(name = "Maquina.findByModelo", query = "SELECT m FROM Maquina m WHERE m.modelo = :modelo")
    , @NamedQuery(name = "Maquina.findByEstado", query = "SELECT m FROM Maquina m WHERE m.estado = :estado")})
public class Maquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMaquina")
    private Integer idMaquina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "maquina")
    private String maquina;
    @Size(max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMaquina", fetch = FetchType.LAZY)
    private List<Maquinanovedad> maquinanovedadList;
    @JoinColumn(name = "codTipo", referencedColumnName = "idTipoMaquina")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipomaquina codTipo;
    @JoinColumn(name = "usuarioRegistro", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMaquina", fetch = FetchType.LAZY)
    private List<Operador> operadorList;

    public Maquina() {
    }

    public Maquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Maquina(Integer idMaquina, String serial, String maquina, String estado) {
        this.idMaquina = idMaquina;
        this.serial = serial;
        this.maquina = maquina;
        this.estado = estado;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Maquinanovedad> getMaquinanovedadList() {
        return maquinanovedadList;
    }

    public void setMaquinanovedadList(List<Maquinanovedad> maquinanovedadList) {
        this.maquinanovedadList = maquinanovedadList;
    }

    public Tipomaquina getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Tipomaquina codTipo) {
        this.codTipo = codTipo;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    @XmlTransient
    public List<Operador> getOperadorList() {
        return operadorList;
    }

    public void setOperadorList(List<Operador> operadorList) {
        this.operadorList = operadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaquina != null ? idMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.idMaquina == null && other.idMaquina != null) || (this.idMaquina != null && !this.idMaquina.equals(other.idMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Maquina[ idMaquina=" + idMaquina + " ]";
    }
    
}
