/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Preproduccion;
import com.dbsics.entities.Preproduccionprod;
import com.dbsics.entities.Produccion;
import com.dbsics.entities.Usuario;
import com.dbsics.facade.PreproduccionFacade;
import com.dbsics.facade.PreproduccionprodFacade;
import com.dbsics.facade.ProduccionFacade;
import com.dbsics.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ivandavid
 */
@Named(value = "controllerPreProduccionProd")
@SessionScoped
public class controllerPreProduccionProd implements Serializable {

    @EJB
    PreproduccionprodFacade PreproduccionprodFacade;
    private Preproduccionprod preproduccionprod;
    private List<Preproduccionprod> listarPreproduccionprod;

    @EJB
    ProduccionFacade produccionfacade;
    private Produccion produccion;

    @EJB
    PreproduccionFacade preproduccionfacade;
    private Preproduccion preproduccion;

    @EJB
    UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public controllerPreProduccionProd() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Pre Produccion Produccion">

    @PostConstruct
    public void init() {
        preproduccionprod = new Preproduccionprod();
        produccion = new Produccion();
        preproduccion = new Preproduccion();
        usuario = new Usuario();
        listarPreproduccionprod = PreproduccionprodFacade.findAll();
    }

    public List<Preproduccionprod> listarPreproduccionprod() {
        return PreproduccionprodFacade.findAll();
    }

    public Preproduccionprod getPreproduccionprod() {
        return preproduccionprod;
    }

    public void setPreproduccionprod(Preproduccionprod preproduccionprod) {
        this.preproduccionprod = preproduccionprod;
    }

    public List<Preproduccionprod> getListarPreproduccionprod() {
        return listarPreproduccionprod;
    }

    public void setListarPreproduccionprod(List<Preproduccionprod> listarPreproduccionprod) {
        this.listarPreproduccionprod = listarPreproduccionprod;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public Preproduccion getPreproduccion() {
        return preproduccion;
    }

    public void setPreproduccion(Preproduccion preproduccion) {
        this.preproduccion = preproduccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void crearPreproduccionprod() {
        try {
            preproduccionprod.setIdPreProduccionProd(null);
            preproduccionprod.setCodProduccion(produccionfacade.find(produccion.getIdProduccion()));
            preproduccionprod.setCodpreProduccion(preproduccionfacade.find(preproduccion.getIdPreProduccion()));
            preproduccionprod.setCodUsuario(usuarioFacade.find(usuario.getIdUsuario()));
            PreproduccionprodFacade.create(this.preproduccionprod);
        } catch (Exception e) {
            System.out.println("Error de datos");
        }
        preproduccionprod = new Preproduccionprod();
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

    public void editarPreproduccionprod() {
        preproduccionprod.setCodProduccion(produccionfacade.find(produccion.getIdProduccion()));
        preproduccionprod.setCodpreProduccion(preproduccionfacade.find(preproduccion.getIdPreProduccion()));
        alertaModificar();
        PreproduccionprodFacade.edit(preproduccionprod);
        preproduccionprod = new Preproduccionprod();
    }

    public String editarPreproduccionprodUrl(Preproduccionprod preproduccionprod) {
        this.preproduccionprod = preproduccionprod;
        return "editarPreproduccionprod";

    }

    public void eliminarPreproduccionprod() {
        PreproduccionprodFacade.remove(preproduccionprod);
        preproduccionprod = new Preproduccionprod();
    }
    // </editor-fold>
}
