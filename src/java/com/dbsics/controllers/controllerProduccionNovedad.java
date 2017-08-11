/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Novedad;
import com.dbsics.entities.Produccion;
import com.dbsics.entities.Produccionnovedad;
import com.dbsics.facade.NovedadFacade;
import com.dbsics.facade.ProduccionFacade;
import com.dbsics.facade.ProduccionnovedadFacade;
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
@Named(value = "controllerProduccionNovedad")
@SessionScoped
public class controllerProduccionNovedad implements Serializable {

    @EJB
    ProduccionnovedadFacade produccionnovedadfacade;
    private Produccionnovedad produccionnovedad;
    private List<Produccionnovedad> listarProduccionnovedad;

    @EJB
    ProduccionFacade produccionfacade;
    private Produccion produccion;

    @EJB
    NovedadFacade novedadfacade;
    private Novedad novedad;

    public controllerProduccionNovedad() {
    }
    // <editor-fold defaultstate="collapsed" desc="Código Produccion Novedad">

    @PostConstruct
    public void init() {
        produccionnovedad = new Produccionnovedad();
        novedad = new Novedad();
        produccion = new Produccion();
        listarProduccionnovedad = produccionnovedadfacade.findAll();
    }

    public List<Produccionnovedad> listarProduccionnovedad() {
        return produccionnovedadfacade.findAll();
    }

    public Produccionnovedad getProduccionnovedad() {
        return produccionnovedad;
    }

    public void setProduccionnovedad(Produccionnovedad produccionnovedad) {
        this.produccionnovedad = produccionnovedad;
    }

    public List<Produccionnovedad> getListarProduccionnovedad() {
        return listarProduccionnovedad;
    }

    public void setListarProduccionnovedad(List<Produccionnovedad> listarProduccionnovedad) {
        this.listarProduccionnovedad = listarProduccionnovedad;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public Novedad getNovedad() {
        return novedad;
    }

    public void setNovedad(Novedad novedad) {
        this.novedad = novedad;
    }

    public void crearProduccionNovedad() {
        try {
            produccionnovedad.setCodNovedad(novedad);
            produccionnovedad.setCodProduccion(produccion);
            produccionnovedadfacade.create(produccionnovedad);
        } catch (Exception e) {
            System.out.println("Error de datos");
        }
        produccionnovedad = new Produccionnovedad();
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

    public void editarProduccionnovedad() {
        produccionnovedad.setCodNovedad(novedadfacade.find(novedad.getIdNovedad()));
        produccionnovedad.setCodProduccion(produccionfacade.find(produccion.getIdProduccion()));
        alertaModificar();
        produccionnovedadfacade.edit(produccionnovedad);
        produccionnovedad = new Produccionnovedad();
    }

    public String editarProduccionnovedadUrl(Produccionnovedad produccionnovedad) {
        this.produccionnovedad = produccionnovedad;
        return "editarProduccionnovedad";
    }

    public void eliminarProduccionnovedad() {
        produccionnovedadfacade.remove(produccionnovedad);
        produccionnovedad = new Produccionnovedad();
    }
    // </editor-fold>
}
