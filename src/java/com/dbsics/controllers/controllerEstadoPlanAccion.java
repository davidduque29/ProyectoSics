/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbsics.controllers;

import com.dbsics.entities.Estadoplanaccion;
import com.dbsics.facade.EstadoplanaccionFacade;
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
@Named(value = "controllerEstadoPlanAccion")
@SessionScoped
public class controllerEstadoPlanAccion implements Serializable {

    @EJB
    EstadoplanaccionFacade estadoFacade;
    private Estadoplanaccion estadoPlan;
    private List<Estadoplanaccion> listaEstadoPlan;

    public controllerEstadoPlanAccion() {
    }

    // <editor-fold defaultstate="collapsed" desc="Código Estado Plan De Accion">
    @PostConstruct
    public void init() {
        estadoPlan = new Estadoplanaccion();
        listaEstadoPlan = estadoFacade.findAll();
    }

    public List<Estadoplanaccion> listarEstado() {
        return estadoFacade.findAll();
    }

    public Estadoplanaccion getEstadoPlan() {
        return estadoPlan;
    }

    public void setEstadoPlan(Estadoplanaccion estadoPlan) {
        this.estadoPlan = estadoPlan;
    }

    public List<Estadoplanaccion> getListaEstadoPlan() {
        return listaEstadoPlan;
    }

    public void setListaEstadoPlan(List<Estadoplanaccion> listaEstadoPlan) {
        this.listaEstadoPlan = listaEstadoPlan;
    }

    public void crearEstado() {
        estadoFacade.create(estadoPlan);
        estadoPlan = new Estadoplanaccion();
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

    public void actualizarEstado() {
        alertaModificar();
        estadoFacade.edit(estadoPlan);
    }
    // </editor-fold>
}
