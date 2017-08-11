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
@Table(name = "stockmaterial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stockmaterial.findAll", query = "SELECT s FROM Stockmaterial s")
    , @NamedQuery(name = "Stockmaterial.findByIdStockMaterial", query = "SELECT s FROM Stockmaterial s WHERE s.idStockMaterial = :idStockMaterial")
    , @NamedQuery(name = "Stockmaterial.findByCodigoBarras", query = "SELECT s FROM Stockmaterial s WHERE s.codigoBarras = :codigoBarras")
    , @NamedQuery(name = "Stockmaterial.findByMaterial", query = "SELECT s FROM Stockmaterial s WHERE s.material = :material")
    , @NamedQuery(name = "Stockmaterial.findByTipo", query = "SELECT s FROM Stockmaterial s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Stockmaterial.findByMarca", query = "SELECT s FROM Stockmaterial s WHERE s.marca = :marca")
    , @NamedQuery(name = "Stockmaterial.findByPeso", query = "SELECT s FROM Stockmaterial s WHERE s.peso = :peso")
    , @NamedQuery(name = "Stockmaterial.findByPesoMedida", query = "SELECT s FROM Stockmaterial s WHERE s.pesoMedida = :pesoMedida")
    , @NamedQuery(name = "Stockmaterial.findByAlto", query = "SELECT s FROM Stockmaterial s WHERE s.alto = :alto")
    , @NamedQuery(name = "Stockmaterial.findByAncho", query = "SELECT s FROM Stockmaterial s WHERE s.ancho = :ancho")
    , @NamedQuery(name = "Stockmaterial.findByDescripcion", query = "SELECT s FROM Stockmaterial s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Stockmaterial.findByCantidad", query = "SELECT s FROM Stockmaterial s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "Stockmaterial.findByEstado", query = "SELECT s FROM Stockmaterial s WHERE s.estado = :estado")})
public class Stockmaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idStockMaterial")
    private Integer idStockMaterial;
    @Size(max = 20)
    @Column(name = "codigoBarras")
    private String codigoBarras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "material")
    private String material;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Size(max = 6)
    @Column(name = "pesoMedida")
    private String pesoMedida;
    @Column(name = "alto")
    private Double alto;
    @Column(name = "ancho")
    private Double ancho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "codStockMaterial", fetch = FetchType.LAZY)
    private List<Produccionmaterial> produccionmaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codStockMaterial", fetch = FetchType.LAZY)
    private List<Sobrante> sobranteList;
    @JoinColumn(name = "usuarioRegistro", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codStockMaterial", fetch = FetchType.LAZY)
    private List<Formula> formulaList;

    public Stockmaterial() {
    }

    public Stockmaterial(Integer idStockMaterial) {
        this.idStockMaterial = idStockMaterial;
    }

    public Stockmaterial(Integer idStockMaterial, String material, String descripcion, String estado) {
        this.idStockMaterial = idStockMaterial;
        this.material = material;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdStockMaterial() {
        return idStockMaterial;
    }

    public void setIdStockMaterial(Integer idStockMaterial) {
        this.idStockMaterial = idStockMaterial;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getPesoMedida() {
        return pesoMedida;
    }

    public void setPesoMedida(String pesoMedida) {
        this.pesoMedida = pesoMedida;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public List<Produccionmaterial> getProduccionmaterialList() {
        return produccionmaterialList;
    }

    public void setProduccionmaterialList(List<Produccionmaterial> produccionmaterialList) {
        this.produccionmaterialList = produccionmaterialList;
    }

    @XmlTransient
    public List<Sobrante> getSobranteList() {
        return sobranteList;
    }

    public void setSobranteList(List<Sobrante> sobranteList) {
        this.sobranteList = sobranteList;
    }

    public Usuario getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(Usuario usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
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
        hash += (idStockMaterial != null ? idStockMaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stockmaterial)) {
            return false;
        }
        Stockmaterial other = (Stockmaterial) object;
        if ((this.idStockMaterial == null && other.idStockMaterial != null) || (this.idStockMaterial != null && !this.idStockMaterial.equals(other.idStockMaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Stockmaterial[ idStockMaterial=" + idStockMaterial + " ]";
    }
    
}
