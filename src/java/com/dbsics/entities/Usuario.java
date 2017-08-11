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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByPmrNombre", query = "SELECT u FROM Usuario u WHERE u.pmrNombre = :pmrNombre")
    , @NamedQuery(name = "Usuario.findBySgdNombre", query = "SELECT u FROM Usuario u WHERE u.sgdNombre = :sgdNombre")
    , @NamedQuery(name = "Usuario.findByPmrApellido", query = "SELECT u FROM Usuario u WHERE u.pmrApellido = :pmrApellido")
    , @NamedQuery(name = "Usuario.findBySgdApellido", query = "SELECT u FROM Usuario u WHERE u.sgdApellido = :sgdApellido")
    , @NamedQuery(name = "Usuario.findByNombreCompleto", query = "SELECT u FROM Usuario u WHERE u.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByFotoCedula", query = "SELECT u FROM Usuario u WHERE u.fotoCedula = :fotoCedula")
    , @NamedQuery(name = "Usuario.findByFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.fechaModificacion = :fechaModificacion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pmrNombre")
    private String pmrNombre;
    @Size(max = 45)
    @Column(name = "sgdNombre")
    private String sgdNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pmrApellido")
    private String pmrApellido;
    @Size(max = 45)
    @Column(name = "sgdApellido")
    private String sgdApellido;
    @Size(max = 100)
    @Column(name = "nombreCompleto")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "clave")
    private String clave;
    @Size(max = 45)
    @Column(name = "correo")
    private String correo;
    @Size(max = 255)
    @Column(name = "fotoCedula")
    private String fotoCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaModificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Rolusuario> rolusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario", fetch = FetchType.LAZY)
    private List<Novedad> novedadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioExplosion", fetch = FetchType.LAZY)
    private List<Preproduccion> preproduccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario", fetch = FetchType.LAZY)
    private List<Solicitudmaterial> solicitudmaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioRegistro", fetch = FetchType.LAZY)
    private List<Maquina> maquinaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioRegistro", fetch = FetchType.LAZY)
    private List<Produccionmaterial> produccionmaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aprobador", fetch = FetchType.LAZY)
    private List<Produccion> produccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioRegistro", fetch = FetchType.LAZY)
    private List<Stockmaterial> stockmaterialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario", fetch = FetchType.LAZY)
    private List<Preproduccionprod> preproduccionprodList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioRegistro", fetch = FetchType.LAZY)
    private List<Plandeaccion> plandeaccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario", fetch = FetchType.LAZY)
    private List<Observaciones> observacionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioRegistro", fetch = FetchType.LAZY)
    private List<Formula> formulaList;
    @JoinColumn(name = "codCargo", referencedColumnName = "idCargo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cargo codCargo;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String pmrNombre, String pmrApellido, String estado, Date fechaModificacion) {
        this.idUsuario = idUsuario;
        this.pmrNombre = pmrNombre;
        this.pmrApellido = pmrApellido;
        this.estado = estado;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPmrNombre() {
        return pmrNombre;
    }

    public void setPmrNombre(String pmrNombre) {
        this.pmrNombre = pmrNombre;
    }

    public String getSgdNombre() {
        return sgdNombre;
    }

    public void setSgdNombre(String sgdNombre) {
        this.sgdNombre = sgdNombre;
    }

    public String getPmrApellido() {
        return pmrApellido;
    }

    public void setPmrApellido(String pmrApellido) {
        this.pmrApellido = pmrApellido;
    }

    public String getSgdApellido() {
        return sgdApellido;
    }

    public void setSgdApellido(String sgdApellido) {
        this.sgdApellido = sgdApellido;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFotoCedula() {
        return fotoCedula;
    }

    public void setFotoCedula(String fotoCedula) {
        this.fotoCedula = fotoCedula;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<Rolusuario> getRolusuarioList() {
        return rolusuarioList;
    }

    public void setRolusuarioList(List<Rolusuario> rolusuarioList) {
        this.rolusuarioList = rolusuarioList;
    }

    @XmlTransient
    public List<Novedad> getNovedadList() {
        return novedadList;
    }

    public void setNovedadList(List<Novedad> novedadList) {
        this.novedadList = novedadList;
    }

    @XmlTransient
    public List<Preproduccion> getPreproduccionList() {
        return preproduccionList;
    }

    public void setPreproduccionList(List<Preproduccion> preproduccionList) {
        this.preproduccionList = preproduccionList;
    }

    @XmlTransient
    public List<Solicitudmaterial> getSolicitudmaterialList() {
        return solicitudmaterialList;
    }

    public void setSolicitudmaterialList(List<Solicitudmaterial> solicitudmaterialList) {
        this.solicitudmaterialList = solicitudmaterialList;
    }

    @XmlTransient
    public List<Maquina> getMaquinaList() {
        return maquinaList;
    }

    public void setMaquinaList(List<Maquina> maquinaList) {
        this.maquinaList = maquinaList;
    }

    @XmlTransient
    public List<Produccionmaterial> getProduccionmaterialList() {
        return produccionmaterialList;
    }

    public void setProduccionmaterialList(List<Produccionmaterial> produccionmaterialList) {
        this.produccionmaterialList = produccionmaterialList;
    }

    @XmlTransient
    public List<Produccion> getProduccionList() {
        return produccionList;
    }

    public void setProduccionList(List<Produccion> produccionList) {
        this.produccionList = produccionList;
    }

    @XmlTransient
    public List<Stockmaterial> getStockmaterialList() {
        return stockmaterialList;
    }

    public void setStockmaterialList(List<Stockmaterial> stockmaterialList) {
        this.stockmaterialList = stockmaterialList;
    }

    @XmlTransient
    public List<Preproduccionprod> getPreproduccionprodList() {
        return preproduccionprodList;
    }

    public void setPreproduccionprodList(List<Preproduccionprod> preproduccionprodList) {
        this.preproduccionprodList = preproduccionprodList;
    }

    @XmlTransient
    public List<Plandeaccion> getPlandeaccionList() {
        return plandeaccionList;
    }

    public void setPlandeaccionList(List<Plandeaccion> plandeaccionList) {
        this.plandeaccionList = plandeaccionList;
    }

    @XmlTransient
    public List<Observaciones> getObservacionesList() {
        return observacionesList;
    }

    public void setObservacionesList(List<Observaciones> observacionesList) {
        this.observacionesList = observacionesList;
    }

    @XmlTransient
    public List<Formula> getFormulaList() {
        return formulaList;
    }

    public void setFormulaList(List<Formula> formulaList) {
        this.formulaList = formulaList;
    }

    public Cargo getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(Cargo codCargo) {
        this.codCargo = codCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dbsics.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
