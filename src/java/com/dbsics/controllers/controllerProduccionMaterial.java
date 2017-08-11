/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Preproduccion;
import com.dbsics.entities.Produccionmaterial;
import com.dbsics.entities.Stockmaterial;
import com.dbsics.entities.Subproceso;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.PreproduccionFacade;
import com.dbsics.facade.ProduccionmaterialFacade;
import com.dbsics.facade.StockmaterialFacade;
import com.dbsics.facade.SubprocesoFacade;
import com.dbsics.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerProduccionMaterial")
@SessionScoped
public class controllerProduccionMaterial implements Serializable {
    
    @EJB
    ProduccionmaterialFacade produccionMaterialFacade;
    private Produccionmaterial prodMaterial;
    private List<Produccionmaterial> listarProduccionMaterial;
    
    @EJB
    StockmaterialFacade materialFacade;
    private Stockmaterial material;
    
    @EJB
    PreproduccionFacade PreProduccionFacade;
    private Preproduccion preProduccion;
    
    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;
    
    @EJB
    SubprocesoFacade subProcesoFacade;
    private Subproceso subProceso;
    
    public controllerProduccionMaterial() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Produccion Material">

    @PostConstruct
    public void init() {
        prodMaterial = new Produccionmaterial();
        material = new Stockmaterial();
        usuario = new Usuario();
        subProceso = new Subproceso();
        preProduccion = new Preproduccion();
        listarProduccionMaterial = produccionMaterialFacade.findAll();
    }
    
    public List<Produccionmaterial> listarProdMaterial() {
        return produccionMaterialFacade.findAll();
    }
    
    public Produccionmaterial getProdMaterial() {
        return prodMaterial;
    }
    
    public void setProdMaterial(Produccionmaterial prodMaterial) {
        this.prodMaterial = prodMaterial;
    }
    
    public List<Produccionmaterial> getListarProduccionMaterial() {
        return listarProduccionMaterial;
    }
    
    public void setListarProduccionMaterial(List<Produccionmaterial> listarProduccionMaterial) {
        this.listarProduccionMaterial = listarProduccionMaterial;
    }
    
    public Stockmaterial getMaterial() {
        return material;
    }
    
    public void setMaterial(Stockmaterial material) {
        this.material = material;
    }
    
    public Preproduccion getPreProduccion() {
        return preProduccion;
    }
    
    public void setPreProduccion(Preproduccion preProduccion) {
        this.preProduccion = preProduccion;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Subproceso getSubProceso() {
        return subProceso;
    }
    
    public void setSubProceso(Subproceso subProceso) {
        this.subProceso = subProceso;
    }
    
    public void crearMaterialProduccion() {
        Calendar c = Calendar.getInstance();
        Date fecha = c.getTime();
        try {
            prodMaterial.setIdProdMaterial(null);
            prodMaterial.setFechaCreacion(fecha);
            prodMaterial.setCodPreProduccion(preProduccion);
            prodMaterial.setCodStockMaterial(material);
            prodMaterial.setUsuarioRegistro(usuario);
            prodMaterial.setCodSubProceso(subProceso);
            produccionMaterialFacade.create(prodMaterial);
            prodMaterial = new Produccionmaterial();
        } catch (Exception e) {
            
        }
    }

    public void alertaModificar() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute(" swal({\n"
                + "  title: \"¿Esta seguro de modificar?\",\n"
                + "  text: \"No podrá deshacer cambios!\",\n"
                + "  type: \"warning\",\n"
                + "  showCancelButton: true,\n"
                + "  confirmButtonColor: \"#DD6B55\",\n"
                + "  confirmButtonText: \"Si, Modificar!\",\n"
                + "  closeOnConfirm: false\n"
                + "},\n"
                + "function(){\n"
                + "  swal(\"Modificado!\", \"Su registro ha sido modificado.\", \"success\");\n"
                + "});");
    }
    
    public void editarProduccionMaterial() {
        
        prodMaterial.setCodPreProduccion(preProduccion);
        prodMaterial.setCodStockMaterial(material);
        prodMaterial.setUsuarioRegistro(usuario);
        prodMaterial.setCodSubProceso(subProceso);
        alertaModificar();
        produccionMaterialFacade.edit(prodMaterial);
        prodMaterial = new Produccionmaterial();
    }
    
    public String editarProduccionMaterialUrl(Produccionmaterial produccionMaterial) {
        this.prodMaterial = produccionMaterial;
        return "editarmaterialproduccion";
        
    }
    
    public void eliminarProduccionMaterial(Preproduccion preprod) {
        produccionMaterialFacade.remove(prodMaterial);
    }
    // </editor-fold>

}
