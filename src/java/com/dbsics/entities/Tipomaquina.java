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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Santi Duque
 */
@Entity
@Table(name = "tipomaquina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipomaquina.findAll", query = "SELECT t FROM Tipomaquina t")
    , @NamedQuery(name = "Tipomaquina.findByIdTipoMaquina", query = "SELECT t FROM Tipomaquina t WHERE t.idTipoMaquina = :idTipoMaquina")
    , @NamedQuery(name = "Tipomaquina.findByTipo", query = "SELECT t FROM Tipomaquina t WHERE t.tipo = :tipo")})
public class Tipomaquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoMaquina")
    private Integer idTipoMaquina;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipo", fetch = FetchType.LAZY)
    private List<Maquina> maquinaList;

    public Tipomaquina() {
    }

    public Tipomaquina(Integer idTipoMaquina) {
        this.idTipoMaquina = idTipoMaquina;
    }

    public Integer getIdTipoMaquina() {
        return idTipoMaquina;
    }

    public void setIdTipoMaquina(Integer idTipoMaquina) {
        this.idTipoMaquina = idTipoMaquina;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Maquina> getMaquinaList() {
        return maquinaList;
    }

    public void setMaquinaList(List<Maquina> maquinaList) {
        this.maquinaList = maquinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMaquina != null ? idTipoMaquina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipomaquina)) {
            return false;
        }
        Tipomaquina other = (Tipomaquina) object;
        if ((this.idTipoMaquina == null && other.idTipoMaquina != null) || (this.idTipoMaquina != null && !this.idTipoMaquina.equals(other.idTipoMaquina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Tipomaquina[ idTipoMaquina=" + idTipoMaquina + " ]";
    }
    
}
